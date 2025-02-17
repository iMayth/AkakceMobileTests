package com.dias.stepdefinitions;

import com.dias.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MainStepDefs extends MainPage {
    @Given("Kullanıcı Akakçe mobil uygulamasını açar")
    public void kullanıcıAkakçeMobilUygulamasınıAçar() {
        clickDontAllow();
    }

    @When("Üye olmadan devam et seçeneğini seçer")
    public void üyeOlmadanDevamEtSeçeneğiniSeçer() {
        clickWithoutRegistrationButton();
    }

    @And("Arama kutusuna {string} yazar ve aratır")
    public void aramaKutusunaYazarVeAratır(String product) {
        sendKeysIntoSearchBox(product);
    }

    @And("Filtrele butonuna tıklar")
    public void filtreleButonunaTıklar() {
        clickFilterButton();
    }

    @And("Alt Kategori olarak {string} seçer ve Ürünleri Gör butonuna tıklar")
    public void altKategoriOlarakSeçerVeÜrünleriGörButonunaTıklar(String categoryName) {
        filter(categoryName);
        clickApplyFilter();
    }

    @And("Sıralama seçeneklerinden {string} seçeneğini seçer")
    public void sıralamaSeçeneklerindenSeçeneğiniSeçer(String optionName) {
        sort();
        selectOption(optionName);
    }

    @Then("Ürün detayı ekranında Satıcıya Git butonunun görüntülendiğini doğrular")
    public void ürünDetayıEkranındaButonununGörüntülendiğiniDoğrular() {
        confirmButton();
    }

    @And("Alt Kategori olarak Bilgisayar, Donanım seçer ve Ürünleri Gör butonuna tıklar")
    public void altKategoriOlarakBilgisayarDonanımSeçerVeÜrünleriGörButonunaTıklar()  {
        clickApplyFilter();
    }

    @And("Sonuç ekranında {int}. ürüne tıklar ve Ürüne Git butonuna tıklar")
    public void sonuçEkranındaÜrüneTıklarVeÜrüneGitButonunaTıklar(int itemNo)  {
        int index = 0;
        int itemCount = 4;
        int newItemCount =0;
        int loopCount = 0;
        for (int i = 1; i <= itemNo; i++){
            scrollLastElementToTop();
            newItemCount = 5;
            itemCount = itemCount + newItemCount;
            loopCount++;
            System.out.println(itemCount);
            if (itemCount>itemNo) {
                break;
            }
        }
        System.out.println("loop" + loopCount + "kez calıstı");
        index = itemCount - itemNo - 1;
        clickIndex(String.valueOf(index));
        clickDetailBtn();
    }
}