import java.util.ArrayList;
import java.util.Scanner;

public class Delivery {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.start();
    }
}

class Kiosk {
    Scanner scan = new Scanner(System.in);
    ArrayList<Shop> shopList = new ArrayList<>();
    ArrayList<Order> orderList = new ArrayList<>();
    ArrayList<Feedback> feedbackList = new ArrayList<>();
    String shopName;
    String foodName;
    String price;
    String customerName;
    int grade;

    void start() {
        String num;
        while (true) {
            System.out.print("[치킨의 민족 프로그램 V1] \n" +
                    "-------------------------\n" +
                    "1) [사장님용] 음식점 등록하기\n" +
                    "2) [고객님과 사장님용] 음식점 별점 조회하기\n" +
                    "3) [고객님용] 음식 주문하기\n" +
                    "4) [고객님용] 별점 등록하기\n" +
                    "5) 프로그램 종료하기\n" +
                    "-------------------------\n" +
                    "[시스템] 무엇을 도와드릴까요? \n" +
                    ">>> ");
            num = scan.nextLine();
            switch (num) {
                case "1":
                    addShop();
                    break;
                case "2":
                    checkFeedback();
                    break;
                case "3":
                    makeOrder();
                    break;
                case "4":
                    makeFeedback();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해주세요");
                    break;
            }
            if (num.equals("5")) {
                break;
            }
        }
    }

    void addShop() {

        System.out.print("[안내] 반갑습니다. 가맹주님!\n");
        shopName = scan.nextLine();
        System.out.print("[안내] 음식점 상호는 무엇인가요?\n" +
                ">>>");
        foodName = scan.nextLine();
        System.out.print("[안내] 해당 메뉴 가격은 얼마인가요?\n" +
                ">>> ");
        price = scan.nextLine();

        Shop shop = new Shop(shopName, foodName, price);
        shopList.add(shop);

        System.out.printf("[안내]%s에 음식(%s, %s) 추가되었습니다.\n" +
                "[시스템] 가게 등록이 정상 처리되었습니다.", shopName, foodName, price);
    }

    void checkFeedback() {
        for (int i = 0; i < feedbackList.size(); i++) {
            System.out.printf("%s [고객님] \n", feedbackList.get(i).getCustomerName());
            System.out.println("--------------------------");
            System.out.printf("주문 매장 : %s \n", feedbackList.get(i).getShopName());
            System.out.printf("주문 메뉴 : %s \n", feedbackList.get(i).getFoodName());
            System.out.print("별점 : ");

            for(int j = 0 ; j<feedbackList.get(i).getGrade(); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void makeOrder() {

        System.out.print("[안내] 고객님! 메뉴 주문을 진행하겠습니다!\n" +
                "[안내] 주문자 이름을 알려주세요!\n" +
                ">>> ");
        customerName = scan.nextLine();
        System.out.print("[안내] 주문할 음식점 상호는 무엇인가요?\n" +
                ">>> ");
        shopName = scan.nextLine();
        System.out.print("[안내] 주문할 메뉴 이름을 알려주세요!\n" +
                ">>> ");
        foodName = scan.nextLine();
        orderList.add(new Order(shopName, foodName, customerName));

    }

    void makeFeedback() {
        System.out.print("[안내] 고객님! 별점 등록을 진행합니다.\n" +
                        "[안내] 주문자 이름은 무엇인가요?\n" +
                        ">>> ");
        customerName = scan.nextLine();
        System.out.print("[안내] 음식점 상호는 무엇인가요?\n" +
                ">>> ");
        shopName = scan.nextLine();
        System.out.print("[안내] 주문하신 음식 이름은 무엇인가요?\n" +
                ">>> ");
        foodName = scan.nextLine();
        System.out.printf("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)\n" +
                ">>> ");
        grade = scan.nextInt();
        scan.nextLine();
        feedbackList.add(new Feedback(shopName, foodName, customerName, grade));
        System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
    }


}

class Shop {
    private String shopName;
    private String foodName;
    private String price;

    public Shop(String shopName, String foodName, String price) {
        this.shopName = shopName;
        this.foodName = foodName;
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

class Order {
    private String shopName;
    private String foodName;
    private String customerName;

    public Order(String shopName, String foodName, String customerName) {
        this.shopName = shopName;
        this.foodName = foodName;
        this.customerName = customerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

class Feedback {
    private String shopName;
    private String foodName;
    private String customerName;
    private int grade;

    public Feedback(String shopName, String foodName, String customerName, int grade) {
        this.shopName = shopName;
        this.foodName = foodName;
        this.customerName = customerName;
        this.grade = grade;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}