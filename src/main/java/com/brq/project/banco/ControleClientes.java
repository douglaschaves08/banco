package com.brq.project.banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/banco")
public class ControleClientes {

    @Autowired
    ClienteInterface clienteInterface;

    @Autowired
    CaixaInterface caixaInterface;

    @PostMapping(value = "/creditarValorContaCliente")
    String creditarValorContaCliente(@RequestBody Cliente cliente) {

        Cliente cliente1 = new Cliente("123", "douglas", 1345);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("bruno");
        cliente2.setCpf("943");
        cliente2.setValor(820);

        clienteInterface.save(cliente1);
        clienteInterface.save(cliente2);

        cliente1.setValor(cliente1.getValor() + cliente.getValor());

        clienteInterface.save(cliente1);

        return "Dinheiro creditado com sucesso.";
    }

    @PostMapping(value = "/sacarConta")
    String sacarConta(@RequestBody Cliente cliente) {

        Cliente clienteNaBase = clienteInterface.findByCpf(cliente.getCpf());
        Optional<Caixa> caixa = caixaInterface.findById("1");

        Integer valorPosCem;
        Integer valorPosCinquenta;
        Integer valorPosVinte;
        Integer valorFinal = 0;
        Integer valorAtualConta = 0;
        Integer totalNotasCem = 0;
        Integer totalNotasCinquenta = 0;
        Integer totalNotasVinte = 0;
        Integer totalNotasDez = 0;

        if (clienteNaBase.getValor() >= cliente.getValor()) {
            if (caixa.get().getValorTotalCaixa() > cliente.getValor()) {
                Integer notasDeCem = cliente.getValor() / 100;
                if (caixa.get().getNotaCem() >= notasDeCem) {
                    valorPosCem = cliente.getValor() - notasDeCem * 100;
                    totalNotasCem = caixa.get().getNotaCem() - notasDeCem;
                } else {
                    valorPosCem = cliente.getValor() - caixa.get().getNotaCem() * 100;
                    totalNotasCem = 0;
                }
                Integer notasDeCinquenta = valorPosCem / 50;
                if (caixa.get().getNotaCinquenta() >= notasDeCinquenta) {
                    valorPosCinquenta = valorPosCem - notasDeCinquenta * 50;
                    totalNotasCinquenta = caixa.get().getNotaCinquenta() - notasDeCinquenta;
                } else {
                    valorPosCinquenta = valorPosCem - caixa.get().getNotaCinquenta() * 50;
                    totalNotasCinquenta = 0;
                }
                Integer notasDeVinte = valorPosCinquenta / 20;
                if (caixa.get().getNotaVinte() >= notasDeVinte) {
                    valorPosVinte = valorPosCinquenta - notasDeVinte * 20;
                    totalNotasVinte = caixa.get().getNotaVinte() - notasDeVinte;
                } else {
                    valorPosVinte = valorPosCinquenta - caixa.get().getNotaVinte() * 20;
                    totalNotasVinte = 0;
                }
                Integer notasDeDez = valorPosVinte / 10;
                if (caixa.get().getNotaDez() >= notasDeDez) {
                    valorFinal = valorPosVinte - notasDeDez * 10;
                    totalNotasDez = caixa.get().getNotaDez() - notasDeDez;
                } else {
                    valorFinal = valorPosVinte - caixa.get().getNotaDez() * 10;
                    totalNotasDez = 0;
                }
            }

            valorAtualConta = clienteNaBase.getValor() - cliente.getValor();


        }
        else {
            return "O valor de saque é maior que o que você possui na conta!!!";
        }


        if(valorFinal == 0) {
            clienteNaBase.setValor(valorAtualConta);
            clienteInterface.save(clienteNaBase);
            caixa.get().setNotaCem(totalNotasCem);
            caixa.get().setNotaCinquenta(totalNotasCinquenta);
            caixa.get().setNotaVinte(totalNotasVinte);
            caixa.get().setNotaDez(totalNotasDez);

            Integer valorTotalCaixa = 100 * caixa.get().getNotaCem() + 50 * caixa.get().getNotaCinquenta() + 20 * caixa.get().getNotaVinte() + 10 * caixa.get().getNotaDez();
            caixa.get().setValorTotalCaixa(valorTotalCaixa);
            caixaInterface.save(caixa.get());

            return "Saque efetuado com sucesso!!!" + " A sua conta atual possui: " + valorAtualConta + " reais";
        }
        else {
            return "Não há notas disponíveis para realizar este saque";
        }
    }
}
