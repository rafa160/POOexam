package com.example.trab.controller;

import com.example.trab.models.Despesa;
import com.example.trab.models.Receita;
import com.example.trab.repository.DespesaRepository;
import com.example.trab.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebControllerDespesa {

    @Autowired
    DespesaRepository repository;

    @Autowired
    ReceitaRepository receitaRepository;

    @RequestMapping("/savedespesa")
    public String process() throws Exception{
        Despesa despesa = new Despesa();
        despesa.setId(1);
        despesa.setDescription("Pagamento OI");
        despesa.setValue(60.00);
        repository.save(despesa);
        return "Saved";
    }

    @RequestMapping("/findalldespesa")
    public String findAll(){
        String result = "<html>";

        for(Despesa despesa : repository.findAll()){
            result += "<div>" + despesa.toStringDespesa() + "</div>";
        }
        return  result + "</html>";
    }

    @RequestMapping("/findbyiddespesa")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return  result;
    }

    @RequestMapping("findbydescdespesa")
    public String findByDesc(@RequestParam("description") String description){
        String result = "<html>";

        for(Despesa despesa : repository.findByDescription(description)){
            result += "<div>" + despesa.toStringDespesa() + "</div>";
        }

        return result + "</html>";
    }

}
