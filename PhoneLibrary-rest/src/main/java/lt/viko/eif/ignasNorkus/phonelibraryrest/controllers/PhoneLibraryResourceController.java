package lt.viko.eif.ignasNorkus.phonelibraryrest.controllers;

import lt.viko.eif.ignasNorkus.phonelibraryrest.models.Phone;
import lt.viko.eif.ignasNorkus.phonelibraryrest.repoes.PhoneLibraryRepository;
import lt.viko.eif.ignasNorkus.phonelibraryrest.transformers.XmlPojoTransformer;
import lt.viko.eif.ignasNorkus.phonelibraryrest.transformers.XsltHtmlConverter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.TransformerException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * A RestController that controls rest services
 */
@RestController
@RequestMapping(value = "/phones", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneLibraryResourceController {
    private final PhoneLibraryRepository phoneLibraryRepository = new PhoneLibraryRepository();

    /**
     * Gets all phones in phone repository
     *
     * @return List Phone
     */
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Phone>>> all() {
        List<EntityModel<Phone>> phones = phoneLibraryRepository.getPhoneLibrary().getPhones().stream()
                .map(phone -> EntityModel.of(phone,
                        linkTo(methodOn(PhoneLibraryResourceController.class).all()).withSelfRel(),
                        linkTo(methodOn(PhoneLibraryResourceController.class).one(phone.getId())).withRel("one")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(CollectionModel.of(phones, linkTo(methodOn(PhoneLibraryResourceController.class).all()).withSelfRel()));
    }

    /**
     * Gets one phone
     *
     * @param id query by which search for a phone is conducted
     * @return Phone
     */
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Phone>> one(@PathVariable Long id) {
        Phone phone = phoneLibraryRepository.getPhoneLibrary().getPhone(id);

        return ResponseEntity.ok(EntityModel.of(phone,
                linkTo(methodOn(PhoneLibraryResourceController.class).one(id)).withSelfRel(),
                linkTo(methodOn(PhoneLibraryResourceController.class).all()).withRel("phones")));
    }

    /**
     * Adds a phone to phoneLibraryRepository
     *
     * @param phone to be added
     * @return a response that confirms success
     */
    @PostMapping
    public ResponseEntity<String> addPhone(@RequestBody Phone phone) {
        phoneLibraryRepository.getPhoneLibrary().addPhone(phone);
        return ResponseEntity.ok("Phone added!");
    }

    /**
     * Replaces a phone based on its id
     *
     * @param id   query on which a phone will be replaced
     * @param phone a phone by which an existing phone will be replaced
     * @return a result confirming the result
     */
    @PutMapping("{id}/replace")
    public ResponseEntity<String> replacePhone(@PathVariable long id, @RequestBody Phone phone) {
        int index = phoneLibraryRepository.getPhoneLibrary().getPhoneIndex(id);
        if (index == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad id");
        }

        phoneLibraryRepository.getPhoneLibrary().replacePhone(phone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Phone[" + id + "] replaced successfully");
    }

    /**
     * Deletes a phone based on its id
     *
     * @param id query by which a phone is deleted from phoneRepository
     * @return a result confirming success or failure
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletePhone(@PathVariable long id) {
        int index = phoneLibraryRepository.getPhoneLibrary().getPhoneIndex(id);
        if (index == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad id");
        }

        phoneLibraryRepository.getPhoneLibrary().getPhones().remove(id);
        return ResponseEntity.ok("Phone[" + id + "] deleted!");
    }

    /**
     * Gets html data
     *
     * @return data in MediaType.TEXT_HTML_VALUE
     */
    @GetMapping(path = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public String getHTML() {
        XmlPojoTransformer xmlPojoTransformer = new XmlPojoTransformer();
        String xmlData = xmlPojoTransformer.transformToXML(phoneLibraryRepository.getPhoneLibrary());
        String htmlData = "";
        try {
            htmlData = XsltHtmlConverter.convertData(phoneLibraryRepository.getXsmlPath(), xmlData);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return htmlData;
    }
}
