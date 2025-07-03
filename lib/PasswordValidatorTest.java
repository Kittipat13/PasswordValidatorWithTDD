package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);
        }

        // Test Case 2: รหัสผ่านมีแค่ตัวเลขควรจะ WEAK
        PasswordStrength result2 = PasswordValidator.validate("12345878");
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 Passed: Simple password is WEAK.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected WEAK but got " + result2);
        }

        // Test Case 3: รหัสผ่านมีตัวหนังสือผสมตัวเลขควรจะ MEDIUM
        PasswordStrength result3 = PasswordValidator.validate("abcd1234");
        if (result3 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 3 Passed: Medium password is MEDIUM.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected MEDIUM but got " + result3);
        }

        // Test Case 4: รหัสผ่านมีตัวพิมพ์เล็กพิมพ์ใหญ่และมีเครื่องหมายพิเศษควรจะ STRONG
        PasswordStrength result4 = PasswordValidator.validate("Abc1234!");
        if (result4 == PasswordStrength.STRONG) {
            System.out.println("Test Case 4 Passed: Strong password is STRONG.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected STRONG but got " + result4);
        }

        System.out.println("--------------------------------");
    }
}
