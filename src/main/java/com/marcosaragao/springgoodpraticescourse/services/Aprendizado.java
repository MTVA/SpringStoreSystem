package com.marcosaragao.springgoodpraticescourse.services;

import java.util.*;

public class Aprendizado {

    public Boolean teste(){
        //HashMap
        Map<String, String> mapaCodificacao = new HashMap<>();
        mapaCodificacao.put("A", "f");
        mapaCodificacao.get("A");

        //Saida de dados
        System.out.println("Hello, world!");

        //Entrada de dados
        Scanner sc = new Scanner(System.in);
        int n1;
        n1 = sc.nextInt();

        //String
        String string, string2;
        string = "Marcos";
        string2 = "MARCOS";
        string.charAt(2);
        string.indexOf('a');
        string.length();
        string.replace("ma", "MA");
        string.replaceAll("a", "A");
        string.substring(1, 4);
        string.toLowerCase();
        string.compareToIgnoreCase(string2);
        string.contains("arcos");
        string.equals(string2);
        string.valueOf(200);
        //retira vazios antes e depois
        string.trim();



        //Array
        int[] array = new int[5];
        int tamanho = array.length;
        String[] diasDaSemana = { "", "Domingo", "Segunda", "Terca",
                "Quarta", "Quinta", "Sexta", "Sabado" };

        //Lista
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("marcos");
        arrayList.remove(3);
        int n = arrayList.size();
        arrayList.contains("marcos");
        arrayList.indexOf("marcos");

        //Lista exceção remove
        try {
            arrayList.remove(3);
        } catch (IndexOutOfBoundsException e) {
            System.out.printf("\nErro: posição inválida (%s).",
                    e.getMessage()); }

        //Interator
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {}

        //HashMap
        Map<Integer, String> mapa = new HashMap<Integer, String>();
        mapa.put(1, "oi");
        mapa.containsValue("oi");
        mapa.containsKey(1);
        mapa.get(1);
        for(Integer i : mapa.keySet()){}
        int tamanhoMapa = mapa.size();
        mapa.isEmpty();



        return true;
    }
}
