/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.advancedjava.thread;

/**
 *
 * @author bas200193
 */
public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task1());
        t1.start();

    }
}
