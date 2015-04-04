import java.sql.*;
public class OdbcAccessInsertRows
{
    public static void main(String [] args)
    {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Airlines");
            Statement sta = con.createStatement();
            String empid[]={
                            "15400","15401","15402","15403","15404","15405","15406","15407","15408","15409","15410","15411","15412","15413","15414","15415","15416","15417","15418","15419",
                            "15420","15421","15422","15423","15424","15425","15426","15427","15428","15429","15430","15431","15432","15433","15434","15435","15436","15437","15438","15439",
                            "15440","15441","15442","15443","15444","15445","15446","15447","15448","15449","15450","15451","15452","15453","15454","15455","15456","15457","15458","15459",
                            "15460","15461","15462","15463","15464","15465","15466","15467","15468","15469","15470","15471","15472","15473","15474","15475","15476","15477","15478","15479",
                            "15480","15481","15482","15483","15484","15485","15486","15487","15488","15489","15490","15491","15492","15493","15494","15495","15496","15497","15498","15499",
                            };
            int adl[]={49318,48436,47003,50411,47372,49695,48504,47340,48838,47600,47674,48784,50024,47763,50887,49068,50973,47815,50773,48329,49351,50947,50965,47238,48656,47085,49821,47318,48030,50109,48139,50118,49300,48303,50516,50113,50815,48825,50245,50573,49253,50981,47592,50491,47754,47920,50756,50291,47583,47680,47987,48152,48973,50504,50136,47607,48897,47988,49229,50516,47201,48832,48769,47522,49889,49844,47029,48848,49275,47318,47942,49480,49338,47062,47019,50839,50795,49022,48321,49489,50237,50880,48578,48665,49160,49952,48381,50173,47771,48335,49726,50661,47169,50496,50234,49308,49848,49339,47004,49631};
            /*int tech[]={15611,15599,16406,16508,15981,15286,15250,16376,15344,16242,16486,15834,15845,15076,16327,15194,16473,16131,15807,16464,16287,15760,16075,15090,16311,16440,15527,15566,15329,15996,16684,15532,16299,16705,16200,16429,15929,16069,15272,15742,16003,16374,15306,15923,16621,15975,15299,16563,16286,16595,16043,15945,15429,15544,15132,15871,15654,15445,15452,15069,15841,16493,16278,15412,15391,15959,15559,15885,16788,15716,15471,15184,16561,15427,15525,16166,16680,16267,16748,15987,16247,16369,16580,16599,16183,15102,15754,16350,16359,15757,15132,15964,15870,15113,15332,16209,16615,15655,16755,16427};
            int acon[]={37708,38464,39636,35399,37038,37506,38343,39262,37923,39013,38423,38444,38901,35607,35417,38580,37099,35555,38108,35520,35841,39124,36997,39564,37684,37353,37906,37150,36632,39953,35253,35251,36796,37039,37468,39303,38348,38921,37639,35074,35480,39006,35691,38318,39969,37138,39330,38366,38085,39402,39528,38133,37846,35462,37548,38097,38022,36041,39384,35956,39887,35995,39992,36568,37428,37780,38931,38728,36635,35784,35800,36049,39506,39148,38418,38993,38628,39157,38797,38600,38553,37304,36815,35050,35664,36362,38926,35569,38955,39606,39366,36482,39902,37455,39133,38506,35662,36339,38392,37435};
            int fix[]={11519,12095,14074,10444,11834,12649,13212,12248,11471,14321,11413,13307,11187,14753,13283,11446,13625,11804,13089,10371,13121,11831,14893,10698,11173,10128,12850,13782,14650,11972,10687,10133,12047,12853,11960,12008,11383,13226,12983,11501,11826,11077,13253,11086,14776,10115,13789,13084,13925,12250,12041,13004,12763,10260,12943,14019,12096,10283,14225,11100,14436,13796,10331,13541,11494,10258,13164,13573,10634,14515,14377,11865,10833,12288,13160,12479,13610,12895,10278,10700,14411,10327,13621,11832,10159,12458,12691,12641,14007,12989,14248,14655,13862,12119,13808,14914,11931,14662,12814,10107};
            int lufa[]={19237,19994,20228,19858,21632,21293,19094,19049,19340,22751,21890,21312,22302,21603,22372,19949,22480,20114,19540,21781,22041,19383,20572,22609,19467,20021,19889,21529,20484,21937,19865,19133,19471,21867,21019,21181,19936,22924,22048,20907,21676,19054,20612,19927,21381,19163,22542,21554,20774,22589,21939,19342,19717,21666,19677,19833,19324,20338,22854,21693,19732,20048,20982,19838,20976,19628,22082,20639,19340,20453,21268,22916,19584,21788,22051,19209,19580,22140,20283,22673,20234,22300,20539,22945,21911,22861,20671,19480,21178,19197,20403,21101,22300,20178,20030,19850,22716,21343,19652,21805};
            int edu[]={279,272,364,211,171,171,221,377,272,206,128,173,260,372,104,101,149,126,256,390,276,210,179,381,115,285,271,349,126,219,354,175,119,301,314,103,220,185,239,151,373,143,163,257,186,178,375,392,397,343,103,320,400,392,387,192,120,239,225,379,118,306,166,222,368,378,210,257,257,163,300,254,101,229,247,349,249,309,189,103,207,169,172,248,185,352,145,118,245,261,333,121,212,133,328,316,196,120,223,183};
            int coop[]={1119,1087,846,1153,1165,967,932,1182,865,1025,1117,916,948,816,934,1095,1141,863,811,1032,974,830,896,1169,871,812,988,920,1079,1175,1009,1084,826,1104,909,987,1185,1134,877,1094,1136,1098,1002,910,1078,1049,1109,822,867,1095,1024,1026,1024,848,1106,930,1033,1007,839,1175,1032,924,904,848,893,928,909,1059,1099,873,1017,1109,1149,1139,902,1095,860,873,1134,881,882,1180,917,807,1176,997,1018,1018,839,941,1126,1146,1069,1036,1069,1050,919,810,933,1166};
            int acec[]={3159,2921,2910,3116,3188,3321,2964,2928,3104,3218,3102,3161,3058,2983,2930,3350,3222,3197,2938,3274,3096,3223,3285,3299,3039,3089,3032,3322,2959,3197,2939,3283,3118,3128,3085,3130,3230,2979,3118,3254,3249,3130,3277,3274,3118,2901,3168,3036,3160,3338,3154,3081,3269,3322,2931,3009,2975,2970,3250,3214,3077,3348,3260,3261,2983,2937,3071,3222,3170,2985,3067,3130,3298,3062,3153,3026,3102,2964,3162,3182,3218,3204,3253,2985,2917,3337,2913,3192,3344,2907,3240,3185,3350,2980,3343,2918,3270,3337,3047,3137};
            int sus[]={276,217,452,160,404,131,488,120,293,402,128,467,420,414,323,450,257,478,321,365,436,164,261,236,454,405,156,134,136,292,246,417,252,103,477,397,104,401,140,436,243,191,259,371,382,368,464,190,456,315,389,147,217,110,360,211,170,169,247,136,371,429,114,308,201,320,301,189,288,343,426,215,162,134,357,175,136,437,379,263,186,136,444,288,196,203,114,219,240,267,204,271,195,307,332,121,262,409,365,445};
            int pen[]={2089,1915,1908,2028,2083,2030,2245,1966,2182,2333,2069,2143,1978,2014,2388,2295,1906,2330,1960,2187,2286,2122,2396,2288,2124,2075,1937,2222,2203,2272,2072,2368,2000,1980,2356,1973,2244,1901,2214,2339,1929,2279,2329,1901,1926,2328,2060,2041,2344,2397,2245,1966,2183,2118,2126,2295,2354,2052,2042,2316,2017,1927,1961,1901,2337,2125,2377,2211,2075,1941,2030,2106,2184,1970,1924,2141,2396,2138,2039,2026,2043,1980,2212,2230,2277,2255,2134,2190,2052,2312,1953,2107,2265,1914,2043,1961,2130,2331,2041,2101};
            int hrent[]={5733,6130,6162,6123,5758,5758,6086,5775,6064,6200,6003,5811,5992,6029,5902,5888,6035,5710,6171,5788,5790,6139,5925,5772,5714,6018,5980,5760,5890,6167,5791,6119,6075,5952,6161,6039,6055,5902,5920,6081,5810,6096,5951,5879,6054,5907,5894,6148,5730,6006,5754,5916,6048,5980,5913,6003,5834,6021,6204,5815,6093,5852,6059,6163,5781,6025,5845,5744,6087,5882,5924,5982,5841,5915,5911,6116,6119,5701,5702,6067,6027,6004,5757,5780,5770,5975,5932,5901,5856,5736,5855,6130,6122,5861,5738,5994,5760,5841,5736,5734};
            int mt[]={1053,1183,997,1146,1200,949,1177,1170,859,1238,1005,1158,942,1003,1199,1174,857,1242,1225,990,876,1062,1044,1161,1105,964,1175,968,1190,850,1229,1012,860,979,943,1015,1226,1135,1184,1162,1155,997,1051,1111,935,1159,1170,1209,1007,988,1082,868,1064,1034,1021,896,875,1027,1068,1191,870,1058,997,911,998,1113,939,1068,1141,865,876,973,1217,1091,1032,1083,1094,981,1159,868,954,924,1164,886,1121,1091,1112,914,925,1244,1070,1213,983,990,925,880,1045,1027,1114,1085};
            int hra[]={1236,1438,1168,969,1132,1598,1005,1345,1262,924,1132,963,1554,1299,1280,1080,991,1049,1259,1333,1540,1202,1035,1337,958,1178,1351,875,1579,900,922,1565,1051,1439,914,1325,1241,1539,1193,900,1437,1381,1507,1125,1659,1188,1136,1317,1295,851,1247,917,1177,1443,1184,1083,1257,1534,1316,854,1590,908,1445,1228,893,1258,1156,1113,915,1287,1278,1350,1650,1189,961,1639,1161,1331,1438,1347,1269,1245,1663,1468,887,1515,1538,1324,1116,995,971,1435,1444,1637,1320,1151,1425,1415,1432,1190};
            int hloan[]={511,310,480,346,166,331,265,461,178,419,271,168,424,343,396,451,451,463,225,187,493,381,519,546,271,169,175,309,325,383,233,358,333,433,284,257,276,400,521,302,523,230,205,206,427,498,454,332,206,505,177,385,481,464,443,238,360,407,359,181,310,171,180,321,264,236,457,201,499,404,384,520,362,298,174,418,336,368,308,202,178,188,314,470,429,311,313,503,341,339,457,245,389,471,479,408,168,528,472,192};*/
            int count = 0;
            for(int i=0;i<100;i++)
            {
int c = sta.executeUpdate("INSERT INTO plideduction"+ " " +"(EMPID,adl)"
                        + " VALUES " +
                        "("+empid[i]+","+adl[i]+")");
                count = count + c;
            }
            System.out.println("Number of rows inserted: "+count);
            sta.close();
            con.close();
        } catch (Exception e) {
                                System.err.println("Exception: "+e.getMessage());
                                }
  }
}