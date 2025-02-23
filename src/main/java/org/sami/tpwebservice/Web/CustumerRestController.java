package org.sami.tpwebservice.Web;


import org.sami.tpwebservice.Entities.Custumer;
import org.sami.tpwebservice.Repository.CustumerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CustumerRestController {
    private CustumerRepo custumerRepo;

    public CustumerRestController(CustumerRepo custumerRepo) {
        this.custumerRepo = custumerRepo;
    }

    @GetMapping("/customers")
    public List<Custumer> getAllCustumers() {
        return custumerRepo.findAll();
    }

    @GetMapping("/customers/{id}")
    public Custumer getCustumerById(@PathVariable(name="id") Long id) {
        return custumerRepo.findById(id).get();
    }

    @PostMapping("/customers")
    public Custumer saveCustumer(@RequestBody Custumer custumer) {
        return custumerRepo.save(custumer);
    }
    @DeleteMapping("/customers/{id}")
    public void DelCustumerById(@PathVariable(name="id") Long id) {
        custumerRepo.deleteById(id);
    }
    @PutMapping("/customers/{id}")
    public Custumer updateCustumer(@PathVariable(name="id") Long id, @RequestBody Custumer nwCustumer) {
        Custumer custumer = custumerRepo.findById(id).get();
        custumer.setName(nwCustumer.getName());
        custumer.setEmail(nwCustumer.getEmail());
        return custumerRepo.save(nwCustumer);
    }

}
