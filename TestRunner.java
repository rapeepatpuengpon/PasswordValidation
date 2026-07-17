// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12") == true);

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw == true);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("pw len = 8",PasswordValidator.validate("aA345678") == true);
        check("pw len < 8",PasswordValidator.validate("aA3456") == false);
        check("pw len > 20",PasswordValidator.validate("2aA3456789876543210123") == false);

        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("pw no upper",PasswordValidator.validate("aaa3456789") == false);

        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("pw no lower",PasswordValidator.validate("AAAA25458245") == false);

        // TODO: R5 - ไม่มีตัวเลข -> false
        check("pw no number",PasswordValidator.validate("aAdjfjdsj") == false);

        // TODO: R6 - มีช่องว่าง -> false
        check("pw no space",PasswordValidator.validate("aA3 45678") == false);

        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
