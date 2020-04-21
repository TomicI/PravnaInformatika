package com.example.demo.controller;

import com.example.demo.model.Roba;
import com.example.demo.model.User;
import com.example.demo.service.ContractRService;
import com.example.demo.service.RobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/roba")
public class RobaController {

    @Autowired
    RobaService robaService;

    @Autowired
    ContractRService contractRService;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST )
    public ResponseEntity<String> getUser(@RequestBody Roba roba) {
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.saveRoba(roba, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/robaUser", method = RequestMethod.GET )
    public ResponseEntity<List<Roba>> getRoba(){
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("user " + user.getUsername());
            return new ResponseEntity<>(robaService.findByVlasnik(user.getUsername()), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/robaUserProdato", method = RequestMethod.GET )
    public ResponseEntity<List<Roba>> getRobaProdato(){
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("user " + user.getUsername());
            return new ResponseEntity<>(robaService.findByVlasnikProdato(user.getUsername()), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/robaUserKupljeno", method = RequestMethod.GET )
    public ResponseEntity<List<Roba>> getRobaKupljeno(){
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("user " + user.getUsername());
            return new ResponseEntity<>(contractRService.findByKupac(user.getUsername()), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/pretraga", method = RequestMethod.PUT )
    public ResponseEntity<List<Roba>> pretraga(@RequestBody String pretraga){
        return new ResponseEntity<>(robaService.pretragaNaziv(pretraga), HttpStatus.OK);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.PUT )
    public ResponseEntity<Roba> getById(@RequestBody String id){
        return new ResponseEntity<>(robaService.getById(Long.valueOf(id)), HttpStatus.OK);
    }


    @ResponseBody
    @RequestMapping(value = "/kupovina", method = RequestMethod.PUT )
    public ResponseEntity<String> kupovina(@RequestBody Long id) {
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.kupovina(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/ukloni/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<String> ukloni(@PathVariable(value="id") Long id) {
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.ukloni(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/robaIsporucena", method = RequestMethod.PUT )
    public ResponseEntity<String> robaIsporucena(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.robaIsporucena(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/robaIsporucenaVracena", method = RequestMethod.PUT )
    public ResponseEntity<String> robaIsporucenaVracena(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.robaIsporucenaVracena(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/novacIsporucen", method = RequestMethod.PUT )
    public ResponseEntity<String> novacIsporucen(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.novacIsporucen(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/novacIsporucenVracen", method = RequestMethod.PUT )
    public ResponseEntity<String> novacIsporucenVracen(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.novacIsporucenVracen(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/kupacNijePreuzeo", method = RequestMethod.PUT )
    public ResponseEntity<String> kupacNijePreuzeo(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.kupacNijePreuzeo(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/kupacOdustanak", method = RequestMethod.PUT )
    public ResponseEntity<String> kupacOdustanak(@RequestBody Long id){
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.kupacOdustanak(id, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/saobraznost/{zamena}/{odustanak}/{umanjenje}", method = RequestMethod.PUT )
    public ResponseEntity<String> saobraznost(@RequestBody Long id, @PathVariable(value="zamena") Boolean zamena, @PathVariable(value="odustanak") Boolean odustanak, @PathVariable(value="umanjenje") Long umanjenje) {
        User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        if(robaService.saobraznost(id, zamena, odustanak, umanjenje, user.getUsername())){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
