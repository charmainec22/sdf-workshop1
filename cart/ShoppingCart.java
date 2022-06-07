package cart;

import java.util.LinkedList;
import java.util.List;


import java.io.Console;
import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        System.out.println("Shopping cart");
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        String input;
        int delIndex;
        boolean stop = false;
        cart.add("apple");
        cart.add("orange");
        cart.add("pear");

        //main loop
        while(!stop){
            input = cons.readLine("> ");
            System.out.printf("READ: %s \n", input);
            //to split the word by space 
            String[] terms = input.split(" ");
            //get the first command 
            String cmd = terms[0];

            switch(cmd){
                case "add":
                    for(int i=1; i < terms.length; i++){
                        boolean found = false;
                        //loop through list
                        for (int j=0; j < cart.size(); j++){
                            //terms -> come from first for loop 
                            if(terms[i].equals(cart.get(j))){
                                //once found get out of loop using break
                                found = true;
                                break;
                            }
                        }
                        if (!found){
                            cart.add(terms[i]);
                            System.out.printf("Added %s to cart", terms[i]);
                        }
                    }
                break;

                case "list":
                if (cart.size() > 0){
                    for (int i = 0; i < cart.size(); i++){
                        System.out.printf("%d. %s \n", (i + 1), cart.get(i));
                    }
                }
                else{
                    System.out.println("Your cart is empty!");
                }
                break;
            }
                


        }
    }
}
