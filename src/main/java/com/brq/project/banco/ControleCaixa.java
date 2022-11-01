package com.brq.project.banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/banco")
public class ControleCaixa {

    @Autowired
    CaixaInterface caixaInterface;

    @PostMapping(value = "/salvaDinheiroCaixa")
    String salvaDinheiroCaixa(@RequestBody Caixa caixamodel) {

        Caixa caixa = new Caixa();
        caixa.setId("1");
        caixa.setNotaCem(2);
        caixa.setNotaCinquenta(55);
        caixa.setNotaVinte(10);
        caixa.setNotaDez(6);

        caixaInterface.save(caixa);

        if (caixa.getNotaCem() + caixamodel.getNotaCem() > 100) {
            return "A quantidade máxima de notas de cem são 100 notas!!!";
        }
        else if(caixa.getNotaCem() + caixamodel.getNotaCem() < 0){
            return "O caixa não tem essa quantidade de notas de cem para ser retirada!!!";
        }
        else {
            caixa.setNotaCem(caixa.getNotaCem() + caixamodel.getNotaCem());
        }

        if(caixa.getNotaCinquenta() + caixamodel.getNotaCinquenta() > 100 && caixa.getNotaCinquenta() + caixamodel.getNotaCinquenta() < 0) {
            return "A quantidade máxima de notas de cinquenta são 100 notas!!!";
        }
        else if(caixa.getNotaCinquenta() + caixamodel.getNotaCinquenta() < 0){
            return "O caixa não tem essa quantidade de notas de cinquenta para ser retirada!!!";
        }
        else {
            caixa.setNotaCinquenta(caixa.getNotaCinquenta() + caixamodel.getNotaCinquenta());
        }

        if(caixa.getNotaVinte() + caixamodel.getNotaVinte() > 100 && caixa.getNotaVinte() + caixamodel.getNotaVinte() < 0) {
            return "A quantidade máxima de notas de vinte são 100 notas!!!";
        }
        else if(caixa.getNotaVinte() + caixamodel.getNotaVinte() < 0){
            return "O caixa não tem essa quantidade de notas de vinte para ser retirada!!!";
        }
        else {
            caixa.setNotaVinte(caixa.getNotaVinte() + caixamodel.getNotaVinte());
        }

        if(caixa.getNotaDez() + caixamodel.getNotaDez() > 100 && caixa.getNotaDez() + caixamodel.getNotaDez() < 0) {
            return "A quantidade máxima de notas de vinte são 100 notas!!!";
        }
        else if(caixa.getNotaDez() + caixamodel.getNotaDez() < 0){
            return "O caixa não tem essa quantidade de notas de dez para ser retirada!!!";
        }
        else {
            caixa.setNotaDez(caixa.getNotaDez() + caixamodel.getNotaDez());
        }

        Integer valorTotalCaixa = 100 * caixa.getNotaCem() + 50 * caixa.getNotaCinquenta() + 20 * caixa.getNotaVinte() + 10 * caixa.getNotaDez();
        caixa.setValorTotalCaixa(valorTotalCaixa);

        caixaInterface.save(caixa);

        return "Dinheiro salvo no caixa";
    }
}
