package com.senac.planilha;

import com.senac.Listas.*;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidOperator;
import com.senac.algoritmos.InvalidToken;

public class Planilha {

        /**
         * @param args
         * @throws InvalidOperator
         * @throws InvalidToken
         */

        public static void main(String[] args) throws InvalidOperator, InvalidToken {
                
                String nome;
                String formula = "";
                double result = 0;
                Lista lista = new Lista();
                Scanner sc1 = new Scanner(System.in);
                while (true) {
                        Celula celula = new Celula();
                        System.out.println("Digite a celula: ");
                        nome = new Scanner(System.in).next();
                        
                if (nome.equalsIgnoreCase("fim")) {
                                System.out.println("Fim do Programa");
                                break;
                        }
                        if(lista.contem(nome)){
                                System.out.println("Formula Atual: " + celula.getnome(nome) + " = " + result + '\n');
                                System.out.println("Nova formula: " + celula.getnome(nome) +  " = "  + '\n');
                                Scanner sc = new Scanner(System.in);
                                formula = sc.nextLine();
                                celula.setformula(formula);
                                lista.adicionaQualquerPosicao(0, celula.getformula());
                                System.out.println("Exbir a lista.\n" + lista.toString());  
                                
                        }        
                     else{
                        celula.setnome(nome);
                        lista.adicionaNoComeco(celula.getnome(nome));                
                        
                        System.out.println("Digite a Formula: ");
                        Scanner sc = new Scanner(System.in);
                        
                        if (formula.equalsIgnoreCase("fim")) {
                                System.out.println("Fim do Programa");
                                break;
                        
                        }
                        
                                formula = sc.nextLine();
                                celula.setformula(formula);
                                lista.adicionaQualquerPosicao(0,celula.getformula());
                     }

                                String postfix = AvaliadorExpressao
                                                .convertInfixToPostfix(formula);
                                result = AvaliadorExpressao.evaluateRPN(postfix);
                                System.out.println(celula.getnome(nome) + '\n');
                                System.out.println(celula.getnome(nome) + ":" + result + '\n');
                                                            
                               
                 }
                                
                }
        
        }
        