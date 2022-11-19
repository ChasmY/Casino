import Controller.ClientController;
import Controller.DealerController;
import Controller.UserController;
import model.Client;
import model.Dealer;
import model.User;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewLayer {
    Dealer dealer = new Dealer("", "", 22);
    DealerController dealerList = new DealerController(new ArrayList<>());
    Client client = new Client("", "", 21, 0);
    ClientController clientList=new ClientController(new ArrayList<>());
    User user = new User("", "", 21);
    UserController userList = new UserController(new ArrayList<>());

    public void start(){
        System.out.println("1 - Log in as a client");
        System.out.println("2 - Log in as a dealer");
        Scanner console = new Scanner(System.in);
        if(console.nextInt()==1){
            loginClient();
            clientLoged();
        }
        else if(console.nextInt()==2)
        {
            loginDealer();
            dealerLoged();
        }


    }

    public void loginClient(){
        Scanner console = new Scanner(System.in);

        System.out.println("Name ");
        user.setName(console.nextLine());


        System.out.println("Password ");
        user.setPassword(console.nextLine());

        System.out.println("Age ");
        user.setAge(console.nextInt());

        User newUser = new User(user.getName(), user.getPassword(), user.getAge());
        userList.add(newUser);

        client.setName(user.getName());
        client.setPassword(user.getPassword());
        client.setAge(user.getAge());

        System.out.println("Money to deposit ");
        client.setCurrentMoney(console.nextInt());
        client.setWinnings(0);
        client.setLosses(0);
        System.out.println(client.getCurrentMoney());

        clientList.add(client);
    }

    public void clientLoged(){
        System.out.println("1 - Choose game");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Check current money");
        System.out.println("4 - Check winnings");
        System.out.println("5 - Check losses");
        Scanner ok = new Scanner(System.in);
        if(ok.nextInt()==1){
            //de ales jocul
        }
        else if(ok.nextInt()==2){
            System.out.println("Enter deposit ");
            Scanner ok1 = new Scanner(System.in);
            client.setWinnings(ok1.nextInt());
            System.out.println(client.getWinnings());

        }
        else if(ok.nextInt()==3){
            System.out.println(client.getCurrentMoney());
        }
        else if(ok.nextInt()==4){
            System.out.println(client.getWinnings());
        }
        else if(ok.nextInt()==5){
            System.out.println(client.getLosses());
        }
    }
    public void loginDealer(){
        Scanner console = new Scanner(System.in);
        System.out.println("Name ");
        dealer.setName(console.nextLine());


        System.out.println("Password ");
        dealer.setPassword(console.nextLine());

        System.out.println("Age ");
        dealer.setAge(console.nextInt());

        userList.add(dealer);
    }

    private void dealerLoged() {

        System.out.println("1 - Show dealers sorted by name");
        System.out.println("2 - Show dealers sorted by age");
        Scanner choice = new Scanner(System.in);
        if(choice.nextInt()==1) {
            System.out.println("1 - Show dealers sorted by name ascending");
            System.out.println("2 - Show dealers sorted by name descending");
            Scanner secondChoice = new Scanner(System.in);
            if(secondChoice.nextInt()==1){
                dealerList.sortByNameAsc();
            }
            else dealerList.sortByNameDsc();
        }
        else if(choice.nextInt()==2) {
            System.out.println("1 - Show dealers sorted by age ascending");
            System.out.println("2 - Show dealers sorted by age descending");
            Scanner thirdChoice = new Scanner(System.in);
            if(thirdChoice.nextInt()==1){
                dealerList.sortByAgeAsc();
            }
            else dealerList.sortByAgeDsc();
        }



    }
    public void chooseGame(){

    }

}
