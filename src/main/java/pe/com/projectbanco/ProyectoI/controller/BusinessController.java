package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Business;
import pe.com.projectbanco.ProyectoI.service.IBusinessService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/business")
public class BusinessController {
    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @Autowired
    private IBusinessService iBusinessService;

   @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Business>> createBusiness(@RequestBody Business business) {
        logger.info("{} {}", "Start BusinessController");
        Mono<Business> p = iBusinessService.create(business);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Business>> findAllBusiness() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Business> listBusiness = iBusinessService.findAll();
        return new ResponseEntity<Flux<Business>>(listBusiness, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Business>> changeBusiness(@RequestBody Business business) {
        Mono<Business> p = iBusinessService.update(business);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable("id") String id)
    {
       Mono<Business> d = iBusinessService.listPorId(id);
       //iMovementService.delete(id);
        return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT); //ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /*{
        return iMovementService.delete(id);

              /*  iMovementService.findById(id).flatMap(p ->{
            return iMovementService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));*/
    //}


}
