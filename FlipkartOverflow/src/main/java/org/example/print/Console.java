package org.example.print;

public class Console implements Print {
    @Override
    public void print(String data)
    {
        System.out.println(data);
    }
}
