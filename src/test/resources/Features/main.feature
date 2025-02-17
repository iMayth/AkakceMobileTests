@main
Feature: Testing the main flow of Akakace app
  Scenario: Kullanıcı üye olmadan laptop arar ve satıcıya gider
    Given Kullanıcı Akakçe mobil uygulamasını açar
    When Üye olmadan devam et seçeneğini seçer
    And Arama kutusuna "Laptop" yazar ve aratır
    And Filtrele butonuna tıklar
    And Alt Kategori olarak "Bilgisayar, Donanım" seçer ve Ürünleri Gör butonuna tıklar
    And Sıralama seçeneklerinden "En Yüksek Fiyat" seçeneğini seçer
    And Sonuç ekranında 10. ürüne tıklar ve Ürüne Git butonuna tıklar
    Then Ürün detayı ekranında Satıcıya Git butonunun görüntülendiğini doğrular