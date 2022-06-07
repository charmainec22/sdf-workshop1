package cart;

import java.util.LinkedList;
import java.util.List;


import java.io.Console;
//import java.util.*;

//create class
public class ShoppingCart {
    //entry point
    public static void main(String[] args) {
        System.out.println("Shopping cart");
        //data structure -> only store string
        List<String> cart = new LinkedList<>();

        // to capture user's input
        Console cons = System.console();

        //variables needed
        String input;
        int delIndex;
        boolean stop = false;

        //predefined items in list so cart not empty
        cart.add("apple");
        cart.add("orange");
        cart.add("pear");

        //main loop

        //if stop is not true, keep asking user
        while(!stop){

            //ask for command
            input = cons.readLine("> ");

            //display command typed in
            System.out.printf("READ: %s \n", input);

            //to split the word by space, translate into array e.g (add apple) -> add & apple will split into 2 diff indexes  
            String[] terms = input.split(" ");

            //get the first command after the split 
            String cmd = terms[0];

            

            switch(cmd){
                case "add":
                    String fruitsStr = terms[1];
                    String fruitsReplaced = fruitsStr.replace(",", " ");
                    String[] fruits = fruitsReplaced.split(" ");

                    //i have to start from 0 as the sentence is split into 0 & 1. with 0 being the command and already filtered off above
                    for(int i=0; i < fruits.length; i++){
                        boolean found = false;
                        //loop through list
                        for (int j=0; j < cart.size(); j++){

                            //fruit -> array gotten after second split, covert both to uppercase when comparing 
                            if((fruits[i].toUpperCase()).equals((cart.get(j).toUpperCase()))){
                                //once found get out of loop using break
                                found = true;
                                System.out.printf("You have %s in your cart \n", fruits[i]);
                                break;
                            }
                        }
                        if (!found){
                            cart.add(fruits[i]);
                            System.out.printf("Added %s to cart \n", fruits[i]);
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

                case "delete":
                    //to make sure it has 2 or more characters
                    if (terms.length <2){
                        System.out.println("Please provide an index in order to delete");
                    }
                    else{

                        try {
                            //minus one because array index starts from 0
                            delIndex = Integer.parseInt(terms[1]) - 1;

                            //if cart size has the index keyed in, proceed to delete otherwise go into else loop 
                            if (delIndex >= 0 && delIndex < cart.size()){
                                System.out.printf("Deleted %s from cart \n", cart.get(delIndex));
                                cart.remove(delIndex);
                            }
                            else {
                                showNoSuchItemToDelete();
                            }
                        }
                        catch (NumberFormatException e){
                            showNoSuchItemToDelete();
                        }
                        
                    }
                    break;

                case "end":
                    stop = true;
                    break;
                default:

            }
                


        }
        System.out.println("Thank you for shopping with us");
    }

    private static void showNoSuchItemToDelete(){
        System.out.println("No such item to delete");
    }
}
