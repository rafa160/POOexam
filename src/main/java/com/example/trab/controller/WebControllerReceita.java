package com.example.trab.controller;

import com.example.trab.models.Receita;
import com.example.trab.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebControllerReceita {

    @Autowired
    ReceitaRepository repository;

    public void validate(Receita receita) throws Exception{
        receita.getValue();
        if (receita.getValue() < 0){
            throw new Exception("Valor da Receita não pode ser menor que 0");
        }
    }

    @RequestMapping("/save")
    public String process() throws Exception{
        Receita despesa = new Receita();
        despesa.setDescription("Salario do Mês");
        despesa.setValue(1900.00);
        validate(despesa);
        repository.save(despesa);
        return "Saved";
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(Receita receita : repository.findAll()){
            result += "<div>" + receita.toString() + "</div>";
        }
        return  result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return  result;
    }

    @RequestMapping("findbydesc")
    public String findByDesc(@RequestParam("description") String description){
        String result = "<html>";

        for(Receita receita : repository.findByDescription(description)){
            result += "<div>" + receita.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id){
        return null;
    }


}
