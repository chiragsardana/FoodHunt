package com.huawei.SBK_FoodHunt;

import com.huawei.hms.site.api.model.Coordinate;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    private static Data instance;
    private static ArrayList<Resturant> resturants;

    private static final String tempDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce pulvinar consectetur dolor at ornare. Vivamus convallis eros congue, aliquet dui sit amet, feugiat velit. Nunc non magna a justo pretium egestas commodo ac nisl. Donec id volutpat velit, eu ultricies turpis. Pellentesque efficitur consectetur massa, vitae volutpat lorem dignissim vitae. Fusce pellentesque, odio et congue volutpat, mi urna sodales est, eu scelerisque ante libero sed nunc. Phasellus faucibus suscipit condimentum. Quisque bibendum rutrum dolor sit amet feugiat.\n" +
            "\n" +
            "Aenean lacinia elit nec mi hendrerit, eget sagittis lorem congue. Mauris vitae mauris dui. Cras turpis lectus, interdum a efficitur et, mollis eget lacus. Donec elit nunc, elementum vitae hendrerit at, sodales eget lacus. Pellentesque id ipsum nunc. Aliquam sit amet posuere felis. Curabitur turpis orci, faucibus et placerat ac, aliquam vitae mi. Ut imperdiet metus mollis aliquet fringilla. Nulla facilisi. Nunc imperdiet purus mauris. Etiam in metus sed nulla bibendum rhoncus.\n" +
            "\n" +
            "Pellentesque a nisi eget sapien feugiat viverra. Mauris vitae sapien quis arcu interdum faucibus eget nec nisl. Curabitur efficitur odio urna, vitae cursus nibh viverra nec. Suspendisse accumsan urna ac justo accumsan, sed aliquet mauris accumsan. Ut eget nisl ut nunc imperdiet interdum nec ut diam. Vestibulum ac facilisis velit, in tempus ipsum. Suspendisse aliquam mauris vel dignissim vulputate. Fusce dapibus auctor fermentum. In consequat porta erat quis scelerisque. Cras bibendum justo et eros blandit, sit amet rutrum arcu scelerisque. Suspendisse ultrices ornare lacus, at tristique ex tincidunt sit amet. Donec ligula justo, tincidunt ultrices lectus et, sollicitudin luctus tortor.";

    private Data() {
        if (null == resturants) {
            resturants = new ArrayList<>();
            initFarmData();
        }
    }

    public static Data getInstance() {
        if (null == instance) {
            instance = new Data();
        }
        return instance;
    }

    public ArrayList<Resturant> getFarms() {
        return resturants;
    }

    public Resturant getFarmById(int id) {
        for (Resturant resturant : resturants) {
            if (resturant.getId() == id) {
                return resturant;
            }
        }
        return null;
    }

    private void initFarmData () {
        resturants = new ArrayList<>(Arrays.asList(
                new Resturant(1, "NCU Cafe 10",
                        "NCU",
                        new Coordinate(28.50337756940972, 77.05007583814063),
                        "https://10619-2.s.cdn12.com/rests/original/102_505849409.jpg",
                        tempDescription),
                new Resturant(2, "OM Sweets",
                        "OM Sweets",
                        new Coordinate(28.510744376562556, 77.04810518020132),
                        "https://media-cdn.tripadvisor.com/media/photo-s/08/76/bc/9a/om-sweets-snacks.jpg",
                        tempDescription),
                new Resturant(3, "Hamoni: Cafe",
                        "Greens",
                        new Coordinate(28.501073840235605, 77.05370326855102),
                        "data:image/jpeg;base64,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",
                        tempDescription),

                new Resturant(4, "Farm Fresh",
                        "Jane Eyre",
                        new Coordinate(7.222749094277214, 80.02059729533626),
                        "https://www.news-medical.net/image.axd?picture=2020%2F1%2Fshutterstock_321864554.jpg",
                        tempDescription),
                new Resturant(5, "Waters Fruits",
                        "Felicity Waters",
                        new Coordinate(7.215820166064452, 80.12112883414713),
                        "https://www.foodsafetynews.com/files/2020/03/fruits-and-vegetables.jpg",
                        tempDescription),
                new Resturant(6, "Nice Vegies",
                        "Darrel Kluger",
                        new Coordinate(7.153455051316645, 80.2440947794111),
                        "https://www.nestle.com/sites/default/files/2021-03/related-vegetables-470.jpg",
                        tempDescription),
                new Resturant(7, "Fruit Literate",
                        "Sophie Elizabeth",
                        new Coordinate(7.088561090692017, 80.20546950407227),
                        "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2F1502826406%2F1708w-getty-fruit-closeup-CarstenSchanter-EyeEm.jpg",
                        tempDescription),
                new Resturant(8, "Veg & Fruit",
                        "John Park",
                        new Coordinate(6.938417885224002, 80.24475718173738),
                        "https://res.cloudinary.com/grohealth/image/upload/v1583748171/DCUK/Content/iStock-857145602.jpg",
                        tempDescription),
                new Resturant(9, "Fruit Farm",
                        "Shawn Mendes",
                        new Coordinate(6.892179988349703, 80.5662849067122),
                        "https://www.unlockfood.ca/EatRightOntario/media/Website-images-resized/How-to-store-fruit-to-keep-it-fresh-resized.jpg",
                        tempDescription),
                new Resturant(10, "Jones' Joy",
                        "Claudia Jones",
                        new Coordinate(6.9172649216129924, 81.70650305282618),
                        "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/publications/food-beverage-nutrition/foodnavigator-asia.com/headlines/policy/china-s-tightened-organic-focus-grapes-and-vegetables-top-list-for-mandatory-contaminant-tests/11546195-2-eng-GB/China-s-tightened-organic-focus-Grapes-and-vegetables-top-list-for-mandatory-contaminant-tests.jpg",
                        tempDescription))
        );
    }
}
