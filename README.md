PetStore API Test Otomasyonu
Bu proje, Swagger PetStore API üzerinde yapılan çeşitli işlemleri test etmek için otomatik API testleri çalıştırır. Testler RestAssured kullanılarak gerçekleştirilir ve test sonuçları Allure raporları ile raporlanır. Proje, farklı API endpoint'lerinin doğruluğunu test eder.

Yapılan İşlemler:
✔ GET İstekleri: Evcil hayvan bilgilerini sorgulama, kullanıcı login ve logout işlemleri gibi GET talepleri test edilir.
✔ POST İstekleri: Yeni kullanıcı oluşturulması, evcil hayvan eklenmesi gibi POST talepleri doğrulanır.
✔ PUT İstekleri: Var olan kullanıcı ve evcil hayvan verilerinin güncellenmesi test edilir.
✔ DELETE İstekleri: Kullanıcı silme işlemleri kontrol edilir.
✔ Login/Logout: Kullanıcı login ve logout işlemleri test edilir.

Her testin sonuçları, proje içerisinde bulunan Allure Test Raporları aracılığıyla raporlanır.
