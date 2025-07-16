import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4:BOGO 1แถม1
        ArrayList<CartItem> FreeCart = new ArrayList<>();
        FreeCart.add(new CartItem("BOGO", "Frozen food", 85.0, 3)); // 85*2 == 170 free 1
        FreeCart.add(new CartItem("BOGO", "Milk", 30.0, 2));      // 30 free 1
        double total7 = ShoppingCartCalculator.calculateTotalPrice(FreeCart);
        if (total7 == 200.0) {
            System.out.println("PASSED: Free cart total is correct (200.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Free cart total expected 200.0 but got " + total7);
            failedCount++;
        }

         //Test 5:ซื้อ BULK ครบ 6 ชิ้นส่วนลด 10%
        ArrayList<CartItem> DiscountCart = new ArrayList<>();
        DiscountCart.add(new CartItem("BULK", "Donut", 10.0, 10)); // 100-(10)== 90 
        DiscountCart.add(new CartItem("BULK", "Yogurt", 12, 6));   // 72-(7.2)==64.8
        double total9 = ShoppingCartCalculator.calculateTotalPrice(DiscountCart);
        if (total9 == 154.8) {
            System.out.println("Tast Case 9 : PASSED: Discount cart total is correct (154.8)");
            passedCount++;
        } else {
            System.out.println("Tast Case 9 : FAILED: Discount cart total expected 154.8 but got " + total9);
            failedCount++;
        }
       
    }
}