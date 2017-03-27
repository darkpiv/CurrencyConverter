package com.darkpiv.currencyconverter.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.darkpiv.currencyconverter.R;
import com.darkpiv.currencyconverter.model.Currency_Names;
import com.darkpiv.currencyconverter.model.Currency_Rates;
import com.darkpiv.currencyconverter.ui.baseui.BaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    public ArrayList<Currency_Rates> list_currency_rates_data;
    public ArrayList<Currency_Names> list_currency_names_data;
    String s_rtes, s_names, s_ids_names, temp = null;
    @BindView(R.id.edt_input_amount)
    MaterialEditText edtInputAmount;
    @BindView(R.id.spn_from)
    BetterSpinner spnFrom;
    @BindView(R.id.spn_to)
    BetterSpinner spnTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        s_rtes = "{\"USDAED\":3.672298,\"USDAFN\":66.498496,\"USDALL\":125.050003,\"USDAMD\":483.540009,\"USDANG\":1.777498,\"USDAOA\":165.085999,\"USDARS\":15.589025,\"USDAUD\":1.310498,\"USDAWG\":1.7905,\"USDAZN\":1.719701,\"USDBAM\":1.805699,\"USDBBD\":2,\"USDBDT\":80.169998,\"USDBGN\":1.810102,\"USDBHD\":0.376199,\"USDBIF\":1692.900024,\"USDBMD\":1,\"USDBND\":1.393803,\"USDBOB\":6.879615,\"USDBRL\":3.107302,\"USDBSD\":1,\"USDBTC\":0.001033,\"USDBTN\":65.474998,\"USDBWP\":10.147298,\"USDBYN\":1.870081,\"USDBYR\":20020,\"USDBZD\":1.9977,\"USDCAD\":1.33266,\"USDCDF\":1341.900024,\"USDCHF\":0.98774,\"USDCLF\":0.02469,\"USDCLP\":659.514885,\"USDCNY\":6.872014,\"USDCOP\":2895.899902,\"USDCRC\":551.080017,\"USDCUC\":1,\"USDCUP\":0.999707,\"USDCVE\":101.660004,\"USDCZK\":24.911402,\"USDDJF\":176.949997,\"USDDKK\":6.85675,\"USDDOP\":46.849998,\"USDDZD\":109.098035,\"USDEEK\":14.461028,\"USDEGP\":18.009789,\"USDERN\":15.290149,\"USDETB\":22.593742,\"USDEUR\":0.921695,\"USDFJD\":2.073991,\"USDFKP\":0.800498,\"USDGBP\":0.79822,\"USDGEL\":2.441301,\"USDGGP\":0.798263,\"USDGHS\":4.338503,\"USDGIP\":0.800697,\"USDGMD\":43.709999,\"USDGNF\":9185.000291,\"USDGTQ\":7.342975,\"USDGYD\":202.710007,\"USDHKD\":7.76703,\"USDHNL\":23.399688,\"USDHRK\":6.8042,\"USDHTG\":67.779999,\"USDHUF\":285.709991,\"USDIDR\":13300,\"USDILS\":3.634501,\"USDIMP\":0.798263,\"USDINR\":65.095001,\"USDIQD\":1181,\"USDIRR\":32420.000141,\"USDISK\":110.050003,\"USDJEP\":0.798263,\"USDJMD\":128.360001,\"USDJOD\":0.707016,\"USDJPY\":110.285004,\"USDKES\":102.650002,\"USDKGS\":68.835999,\"USDKHR\":3945.899902,\"USDKMF\":460.549988,\"USDKPW\":900.000413,\"USDKRW\":1113.300049,\"USDKWD\":0.304023,\"USDKYD\":0.819813,\"USDKZT\":316.48999,\"USDLAK\":8183.999713,\"USDLBP\":1505.499452,\"USDLKR\":151.399994,\"USDLRD\":91.000041,\"USDLSL\":12.439842,\"USDLTL\":3.048698,\"USDLVL\":0.62055,\"USDLYD\":1.414501,\"USDMAD\":9.940301,\"USDMDL\":19.434999,\"USDMGA\":3189.999954,\"USDMKD\":56.720001,\"USDMMK\":1366.000412,\"USDMNT\":2447.999402,\"USDMOP\":7.999798,\"USDMRO\":357.000314,\"USDMUR\":35.130001,\"USDMVR\":15.419869,\"USDMWK\":716.900024,\"USDMXN\":18.785999,\"USDMYR\":4.412029,\"USDMZN\":70.440002,\"USDNAD\":12.424018,\"USDNGN\":314.999879,\"USDNIO\":29.349872,\"USDNOK\":8.45395,\"USDNPR\":104.349998,\"USDNZD\":1.418494,\"USDOMR\":0.3849,\"USDPAB\":1,\"USDPEN\":3.240501,\"USDPGK\":3.164597,\"USDPHP\":50.119999,\"USDPKR\":104.599998,\"USDPLN\":3.935027,\"USDPYG\":5621.999754,\"USDQAR\":3.640898,\"USDRON\":4.187499,\"USDRSD\":114.770798,\"USDRUB\":57.014999,\"USDRWF\":817.280029,\"USDSAR\":3.749902,\"USDSBD\":7.776597,\"USDSCR\":13.547961,\"USDSDG\":6.666976,\"USDSEK\":8.779401,\"USDSGD\":1.3944,\"USDSHP\":0.800698,\"USDSLL\":7450.000426,\"USDSOS\":544.99976,\"USDSRD\":7.480301,\"USDSTD\":22589,\"USDSVC\":8.722031,\"USDSYP\":514.97998,\"USDSZL\":12.401299,\"USDTHB\":34.429895,\"USDTJS\":8.144402,\"USDTMT\":3.41,\"USDTND\":2.253102,\"USDTOP\":2.304301,\"USDTRY\":3.603396,\"USDTTD\":6.708986,\"USDTWD\":30.302999,\"USDTZS\":2227.999827,\"USDUAH\":27.089697,\"USDUGX\":3582.000039,\"USDUSD\":1,\"USDUYU\":28.059999,\"USDUZS\":3534.99986,\"USDVEF\":9.975029,\"USDVND\":22774,\"USDVUV\":106.379997,\"USDWST\":2.565602,\"USDXAF\":604.249992,\"USDXAG\":0.055975,\"USDXAU\":0.000796,\"USDXCD\":2.70159,\"USDXDR\":0.733615,\"USDXOF\":610.349976,\"USDXPF\":109.440002,\"USDYER\":249.949997,\"USDZAR\":12.3989,\"USDZMK\":5156.095038,\"USDZMW\":9.480166,\"USDZWL\":322.355011}";
        add_currency_rates();
        s_names = "{\"AED\":\"United Arab Emirates Dirham\",\"AFN\":\"Afghan Afghani\",\"ALL\":\"Albanian Lek\",\"AMD\":\"Armenian Dram\",\"ANG\":\"Netherlands Antillean Guilder\",\"AOA\":\"Angolan Kwanza\",\"ARS\":\"Argentine Peso\",\"AUD\":\"Australian Dollar\",\"AWG\":\"Aruban Florin\",\"AZN\":\"Azerbaijani Manat\",\"BAM\":\"Bosnia-Herzegovina Convertible Mark\",\"BBD\":\"Barbadian Dollar\",\"BDT\":\"Bangladeshi Taka\",\"BGN\":\"Bulgarian Lev\",\"BHD\":\"Bahraini Dinar\",\"BIF\":\"Burundian Franc\",\"BMD\":\"Bermudan Dollar\",\"BND\":\"Brunei Dollar\",\"BOB\":\"Bolivian Boliviano\",\"BRL\":\"Brazilian Real\",\"BSD\":\"Bahamian Dollar\",\"BTC\":\"Bitcoin\",\"BTN\":\"Bhutanese Ngultrum\",\"BWP\":\"Botswanan Pula\",\"BYN\":\"New Belarusian Ruble\",\"BYR\":\"Belarusian Ruble\",\"BZD\":\"Belize Dollar\",\"CAD\":\"Canadian Dollar\",\"CDF\":\"Congolese Franc\",\"CHF\":\"Swiss Franc\",\"CLF\":\"Chilean Unit of Account (UF)\",\"CLP\":\"Chilean Peso\",\"CNY\":\"Chinese Yuan\",\"COP\":\"Colombian Peso\",\"CRC\":\"Costa Rican Col\\u00f3n\",\"CUC\":\"Cuban Convertible Peso\",\"CUP\":\"Cuban Peso\",\"CVE\":\"Cape Verdean Escudo\",\"CZK\":\"Czech Republic Koruna\",\"DJF\":\"Djiboutian Franc\",\"DKK\":\"Danish Krone\",\"DOP\":\"Dominican Peso\",\"DZD\":\"Algerian Dinar\",\"EEK\":\"Estonian Kroon\",\"EGP\":\"Egyptian Pound\",\"ERN\":\"Eritrean Nakfa\",\"ETB\":\"Ethiopian Birr\",\"EUR\":\"Euro\",\"FJD\":\"Fijian Dollar\",\"FKP\":\"Falkland Islands Pound\",\"GBP\":\"British Pound Sterling\",\"GEL\":\"Georgian Lari\",\"GGP\":\"Guernsey Pound\",\"GHS\":\"Ghanaian Cedi\",\"GIP\":\"Gibraltar Pound\",\"GMD\":\"Gambian Dalasi\",\"GNF\":\"Guinean Franc\",\"GTQ\":\"Guatemalan Quetzal\",\"GYD\":\"Guyanaese Dollar\",\"HKD\":\"Hong Kong Dollar\",\"HNL\":\"Honduran Lempira\",\"HRK\":\"Croatian Kuna\",\"HTG\":\"Haitian Gourde\",\"HUF\":\"Hungarian Forint\",\"IDR\":\"Indonesian Rupiah\",\"ILS\":\"Israeli New Sheqel\",\"IMP\":\"Manx pound\",\"INR\":\"Indian Rupee\",\"IQD\":\"Iraqi Dinar\",\"IRR\":\"Iranian Rial\",\"ISK\":\"Icelandic Kr\\u00f3na\",\"JEP\":\"Jersey Pound\",\"JMD\":\"Jamaican Dollar\",\"JOD\":\"Jordanian Dinar\",\"JPY\":\"Japanese Yen\",\"KES\":\"Kenyan Shilling\",\"KGS\":\"Kyrgystani Som\",\"KHR\":\"Cambodian Riel\",\"KMF\":\"Comorian Franc\",\"KPW\":\"North Korean Won\",\"KRW\":\"South Korean Won\",\"KWD\":\"Kuwaiti Dinar\",\"KYD\":\"Cayman Islands Dollar\",\"KZT\":\"Kazakhstani Tenge\",\"LAK\":\"Laotian Kip\",\"LBP\":\"Lebanese Pound\",\"LKR\":\"Sri Lankan Rupee\",\"LRD\":\"Liberian Dollar\",\"LSL\":\"Lesotho Loti\",\"LTL\":\"Lithuanian Litas\",\"LVL\":\"Latvian Lats\",\"LYD\":\"Libyan Dinar\",\"MAD\":\"Moroccan Dirham\",\"MDL\":\"Moldovan Leu\",\"MGA\":\"Malagasy Ariary\",\"MKD\":\"Macedonian Denar\",\"MMK\":\"Myanma Kyat\",\"MNT\":\"Mongolian Tugrik\",\"MOP\":\"Macanese Pataca\",\"MRO\":\"Mauritanian Ouguiya\",\"MUR\":\"Mauritian Rupee\",\"MVR\":\"Maldivian Rufiyaa\",\"MWK\":\"Malawian Kwacha\",\"MXN\":\"Mexican Peso\",\"MYR\":\"Malaysian Ringgit\",\"MZN\":\"Mozambican Metical\",\"NAD\":\"Namibian Dollar\",\"NGN\":\"Nigerian Naira\",\"NIO\":\"Nicaraguan C\\u00f3rdoba\",\"NOK\":\"Norwegian Krone\",\"NPR\":\"Nepalese Rupee\",\"NZD\":\"New Zealand Dollar\",\"OMR\":\"Omani Rial\",\"PAB\":\"Panamanian Balboa\",\"PEN\":\"Peruvian Nuevo Sol\",\"PGK\":\"Papua New Guinean Kina\",\"PHP\":\"Philippine Peso\",\"PKR\":\"Pakistani Rupee\",\"PLN\":\"Polish Zloty\",\"PYG\":\"Paraguayan Guarani\",\"QAR\":\"Qatari Rial\",\"RON\":\"Romanian Leu\",\"RSD\":\"Serbian Dinar\",\"RUB\":\"Russian Ruble\",\"RWF\":\"Rwandan Franc\",\"SAR\":\"Saudi Riyal\",\"SBD\":\"Solomon Islands Dollar\",\"SCR\":\"Seychellois Rupee\",\"SDG\":\"Sudanese Pound\",\"SEK\":\"Swedish Krona\",\"SGD\":\"Singapore Dollar\",\"SHP\":\"Saint Helena Pound\",\"SLL\":\"Sierra Leonean Leone\",\"SOS\":\"Somali Shilling\",\"SRD\":\"Surinamese Dollar\",\"STD\":\"S\\u00e3o Tom\\u00e9 and Pr\\u00edncipe Dobra\",\"SVC\":\"Salvadoran Col\\u00f3n\",\"SYP\":\"Syrian Pound\",\"SZL\":\"Swazi Lilangeni\",\"THB\":\"Thai Baht\",\"TJS\":\"Tajikistani Somoni\",\"TMT\":\"Turkmenistani Manat\",\"TND\":\"Tunisian Dinar\",\"TOP\":\"Tongan Pa\\u02bbanga\",\"TRY\":\"Turkish Lira\",\"TTD\":\"Trinidad and Tobago Dollar\",\"TWD\":\"New Taiwan Dollar\",\"TZS\":\"Tanzanian Shilling\",\"UAH\":\"Ukrainian Hryvnia\",\"UGX\":\"Ugandan Shilling\",\"USD\":\"United States Dollar\",\"UYU\":\"Uruguayan Peso\",\"UZS\":\"Uzbekistan Som\",\"VEF\":\"Venezuelan Bol\\u00edvar Fuerte\",\"VND\":\"Vietnamese Dong\",\"VUV\":\"Vanuatu Vatu\",\"WST\":\"Samoan Tala\",\"XAF\":\"CFA Franc BEAC\",\"XAG\":\"Silver (troy ounce)\",\"XAU\":\"Gold (troy ounce)\",\"XCD\":\"East Caribbean Dollar\",\"XDR\":\"Special Drawing Rights\",\"XOF\":\"CFA Franc BCEAO\",\"XPF\":\"CFP Franc\",\"YER\":\"Yemeni Rial\",\"ZAR\":\"South African Rand\",\"ZMK\":\"Zambian Kwacha (pre-2013)\",\"ZMW\":\"Zambian Kwacha\",\"ZWL\":\"Zimbabwean Dollar\"}";
        add_country_names();
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }

    public void add_currency_rates() {
        list_currency_rates_data = new ArrayList<>();
        s_rtes = s_rtes.replace("{", "");
        s_rtes = s_rtes.replace("}", "");
        s_rtes = s_rtes.replace("\"", "");
        s_rtes = s_rtes.replace("\n", "");

        StringTokenizer stok = new StringTokenizer(s_rtes, ",");

        while (stok.hasMoreElements()) {

            String temp = stok.nextElement().toString();

            String split[] = temp.split(":");

            double amount = Double.parseDouble(split[1]);

            DecimalFormat df1 = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));

            String refinedNumber = df1.format(amount);

            split[1] = String.valueOf(refinedNumber);

            list_currency_rates_data.add(new Currency_Rates(split[0], split[1]));

        }

        Collections.sort(list_currency_rates_data, new Comparator<Currency_Rates>() {
            @Override
            public int compare(Currency_Rates r1, Currency_Rates r2) {
                return r1.title.compareTo(r2.title);
            }
        });
        Log.d("XXX", "add_currency_rates: " + list_currency_rates_data.size());

    }

    public void add_country_names() {
        list_currency_names_data = new ArrayList<>();
        s_names = s_names.replace("{", "");
        s_names = s_names.replace("}", "");
        s_names = s_names.replace("\"", "");

        StringTokenizer stoke = new StringTokenizer(s_names, ",");

        while (stoke.hasMoreElements()) {

            String temp = stoke.nextElement().toString();
            String split[] = temp.split(":");

            list_currency_names_data.add(new Currency_Names(split[0], split[1]));

        }

        Collections.sort(list_currency_names_data, new Comparator<Currency_Names>() {
            @Override
            public int compare(Currency_Names n1, Currency_Names n2) {
                return n1.short_name.compareTo(n2.short_name);
            }
        });
        Log.d("xxx", "add_country_names: " + list_currency_names_data.size());
    }
}