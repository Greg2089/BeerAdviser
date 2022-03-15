package com.hfad.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Spinner;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();//Добавьте экземпляр BeerExpert как приватную переменную.

    @Override
    protected void onCreate(Bundle savedInstanceState) //метод вызывается при исходном создании активности
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);/*Метод setContentView сообщает Android, какой макет
        используется активностью.В данном случае это макет activity_find_beer.*/
    }

    //Called when the user clicks the button
    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
//Получить ссылку на Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
//Получить вариант, выбранный в Spinner
        String beerType = String.valueOf(color.getSelectedItem()); /*Конструкция: color.getSelectedItem()
        возвращает обобщенный объект Java. Этот объект необходимо преобразовать в String.*/

        /**Для перевода экземпляра любого Java-класса или
         любого примитивного типа данных к строковому представлению, можно использовать метод String.valueOf():*/
        //Получить рекомендации от класса BeerExpert
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();/*Здесь строится объект String, в котором каждый
        сорт выводится с новой строки.*/
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
//Вывести сорта пива
        brands.setText(brandsFormatted);//Содержимое String отображается в надписи.
/*Вывести выбранный вариант
        brands.setText(beerType);*/
    }

}

