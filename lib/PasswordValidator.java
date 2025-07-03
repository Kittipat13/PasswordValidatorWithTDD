package lib;

public class PasswordValidator {

    /**
     * ตรวจสอบความแข็งแรงของรหัสที่ผู้ใช้กรอกเช้ามา โดยดูจากความยาว
     * ตัวอักษร ตัวเลข เครื่องหมายพิเศษ
     * @param password รหัสผ่านที่ต้องการตรวจสอบ
     * @return ระดับความแข็งแกร่งของรหัสผ่าน(INVALID WEAK MEDIUM STRONG)
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        if (password == null || password.length() < 8){
            return PasswordStrength.INVALID;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }
        
        if(hasDigit && !hasUpper && !hasLower && !hasSpecial){
            return PasswordStrength.WEAK;
        }
        
        if(hasLower && hasDigit && !hasSpecial){
            return PasswordStrength.MEDIUM;
        }

        if(hasLower && hasUpper && hasDigit && hasSpecial){
            return PasswordStrength.STRONG;
        }

        return PasswordStrength.WEAK;
    }
}