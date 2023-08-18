# آشنایی با نحوه پروفایل برنامه (Profiling)

#### آزمایش پنج درس آز مهندسی نرم افزار 
---
### گزارش آزمایش:
بخش اول:
ابتدا نرم افزار YourKit-JavaProfiler را مطابق آموزش ها گفته شده داخل دستور کار آزمایش دانلود و نصب می کنیم و سپس آن را با استفاده از لایسنس 15 روزه رایگان آن فعال می کنیم سپس وارد نرم افزار می شویم 

![image](https://github.com/amirzgh/se-lab-5/assets/59364450/55cf3a13-6989-4e75-ae31-a92b19298a3f)

در این قسمت نیاز است که آن را به IDE مورد استفاده خود متصل کنیم برای این کار 
گزینه Profile from within IDE را انتخاب می کنیم سپس در منو باز شده IDE مورد نظر را انتخاب و مراحل را پیش می رویم 

![image](https://github.com/amirzgh/se-lab-5/assets/59364450/6dff19c2-9aea-49de-905e-4818d269c42d)

پس از آن وارد IDE خود می شویم و کلاسی را که می خواهیم پروفایل کنیم را انتخاب و پلاگین Your-Kit را اجرا می کنیم 

![Screenshot 2023-08-17 104318](https://github.com/amirzgh/se-lab-5/assets/59364450/339a9e38-aba2-47a2-84d6-09d15aabd921)

پس از انتخاب این مورد برنامه آماده اجرا به صورت پروفایل خواهد بود و نرم افزار Your-kit نیز مانیتور برنامه را شروع می کند ( نکته ای که وجود دارد چون برنامه پردازشی انجام نمی دهد و صرفا اماده شروع به کار می باشد نمودار استفاده از منابع به صورت زیر می باشد و استفاده از منبعی را شناسایی نمی کند در ادامه با اجرا کلاس نمودار استفاده از منبع را شناسایی می کند و نمایش می دهد )

![Screenshot 2023-08-17 084846](https://github.com/amirzgh/se-lab-5/assets/59364450/ca4c3986-7f84-46ef-b299-1e5e87b495cb)

سپس کلاس به کلاس ورودی های مورد نیاز را می دهیم تا اجرا شود 
داخل نرم افزار Your-kit نمودار به صورت زیر می باشد 

![Screenshot 2023-08-17 084953](https://github.com/amirzgh/se-lab-5/assets/59364450/e08a81ad-6501-4304-9104-05d3601e2608)
![Screenshot 2023-08-17 085007](https://github.com/amirzgh/se-lab-5/assets/59364450/82881a73-1317-4447-a9f4-e17c8b0a9439)


و می بینیم که انتهای چارت ها استفاده زیادی از منابع شده است  و همین طور در تب Exceptions می بینیم که برنامه دچار مشکل نیز شده است 

![Screenshot 2023-08-17 085030](https://github.com/amirzgh/se-lab-5/assets/59364450/65bcd0a5-7edd-4e44-a09e-d97cb2dfa98c)

حال با کلیک بر روی قسمتی از نمودار که بیشترین مصرف را داشته است و نگاه به جدول پایین می توانیم ببینیم که در آن لحظه کدام متد ها بیشترین مصرف منابع را داشته اند 

![Screenshot 2023-08-17 085449](https://github.com/amirzgh/se-lab-5/assets/59364450/41e637d2-a862-41c2-b458-200d8f139751)


در اینجا قابل مشاهده می باشد که تابع Temp مصرف زیادی از منابع را داشته است 
پس از بررسی کد متوجه می شویم که تابع Temp اصلا کارایی داخل کد و هدف برنامه ندارد برای همین آن را پاک کرده و مجددا برنامه را پروفایل می کنیم تا نتیجه را بررسی کنیم.
–

![Screenshot 2023-08-17 085958](https://github.com/amirzgh/se-lab-5/assets/59364450/892c6057-f0f0-4c8e-9c19-b9376ec1a2e9)
![Screenshot 2023-08-17 090043](https://github.com/amirzgh/se-lab-5/assets/59364450/1b6f2bbb-b94d-4b78-9895-97b1779e40ff)


همان طور که در عکس ها بالا هم قابل مشاهده می باشد استفاده از منابع به شدت کاهش یافته است و همین طور برنامه دچار مشکلی نشده و به درستی اجرا می شود 
## بخش دوم
اکمنون تابع توان را به نحوه زیر پیاده سازی کردیم
```.java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press base number: ");
        int i = scanner.nextInt();
        System.out.println("Press power number: ");
        int j = scanner.nextInt();

        power(i, j);
    }

        public static void power(int a, int b) {
        int result = 1;
        for (int i =1; i < b ; i++) {
            result *= a;
        }
        System.out.println("result: " + result);
    }

}
```
با استفاده از این کد مقدار 2 به توان 30 را محاسبه میکنیم و نتیجه پروفایلینگ آن به شکل زیر است.
![image](https://github.com/amirzgh/se-lab-5/assets/59579792/ef80366b-5c5a-4d65-8154-869dc51b9b2e)
![image](https://github.com/amirzgh/se-lab-5/assets/59579792/3dad1684-2efc-435f-b9c0-02755de9d0aa)
که همانظور که انتظار میرفت نتیجه مطلوبی نداشت از همین روی بار دیگر این قسمت را مینویسیم این بار با استفاده از کتابخانه Math
```.java
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press base number: ");
        int i = scanner.nextInt();
        System.out.println("Press power number: ");
        int j = scanner.nextInt();

        power(i, j);
    }

    public static void power(int a, int b) {
        double result = Math.pow(a, b);
        System.out.println("result: " + result);
    }
}
```
و بار دیگر نتیجه پروفایلینگ آن را بررسی میکنیم
![image](https://github.com/amirzgh/se-lab-5/assets/59579792/49efd356-0097-4f97-b52a-76d46eae3de5)
![image](https://github.com/amirzgh/se-lab-5/assets/59579792/146a9edd-6b6d-4ac4-979a-398b994f9f24)
همانطور که مشاهده میشود بهبود چشم گیری در نتیجه پروفایلینگ این قسمت از کد به وجود آمد.
