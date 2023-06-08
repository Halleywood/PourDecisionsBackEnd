package com.sei.capstone.seed;


import com.sei.capstone.model.Post;
import com.sei.capstone.model.User;
import com.sei.capstone.model.UserProfile;
import com.sei.capstone.model.Wine;
import com.sei.capstone.repository.PostRepository;
import com.sei.capstone.repository.UserProfileRepository;
import com.sei.capstone.repository.UserRepository;
import com.sei.capstone.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SeedData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserProfileRepository profileRepository;
    private final WineRepository wineRepository;
    private final PostRepository postRepository;


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public SeedData(UserRepository userRepository, UserProfileRepository profileRepository, WineRepository wineRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.wineRepository = wineRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createData();
    }

    private void createData() {
        User user = new User();
        user.setId(1L);
        user.setEmail("kyle@ga.com");
        user.setPassword(encoder.encode("password"));
        userRepository.save(user);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setUserName("Kyle");
        userProfile.setTagline("I'm not wine-ing, I'm just expressing my grape expectations");
        userProfile.setImgSrc("https://as1.ftcdn.net/v2/jpg/04/99/30/64/1000_F_499306468_V976AiLgS10Ib9zvwiE068UjV2OArHgf.jpg");
        userProfile.setUser(user);
        profileRepository.save(userProfile);
        user.setUserProfile(userProfile);

        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("kelsey@ga.com");
        user2.setPassword(encoder.encode("password"));
        userRepository.save(user2);
        UserProfile userProfile2 = new UserProfile("Kelso92", "I'm just vine thanks for asking", "https://as2.ftcdn.net/v2/jpg/06/00/30/45/1000_F_600304524_Xcatgs0f5Ot1um71tjLUPTZyUJIpw37z.jpg");
        userProfile2.setId(2L);
        userProfile2.setUser(user2);
        profileRepository.save(userProfile2);
        user2.setUserProfile(userProfile2);

        User user3 = new User();
        user3.setId(3L);
        user3.setEmail("john@ga.com");
        user3.setPassword(encoder.encode("password"));
        userRepository.save(user3);
        UserProfile userProfile3 = new UserProfile("John", "I'm aging like a fine wine, getting better with time", "https://as2.ftcdn.net/v2/jpg/02/90/61/65/1000_F_290616592_7ceZwuFzdeNIfAXwi0jfPezyeTIVo7Sl.jpg");
        userProfile3.setId(3L);
        userProfile3.setUser(user3);
        profileRepository.save(userProfile3);
        user3.setUserProfile(userProfile3);

        User user4 = new User();
        user4.setId(4L);
        user4.setEmail("kenny@ga.com");
        user4.setPassword(encoder.encode("password"));
        userRepository.save(user4);
        UserProfile userProfile4 = new UserProfile("Kenny G", "It's time to wine down and relax", "https://as2.ftcdn.net/v2/jpg/02/87/93/49/1000_F_287934961_okn8NMr2iKWA7KpycCjr8yEZg2X373fl.jpg");
        userProfile4.setId(4L);
        userProfile4.setUser(user4);
        profileRepository.save(userProfile4);
        user4.setUserProfile(userProfile4);

        User user5 = new User();
        user5.setId(5L);
        user5.setEmail("lindsay@ga.com");
        user5.setPassword(encoder.encode("password"));
        userRepository.save(user5);
        UserProfile userProfile5 = new UserProfile("LindsayLovesLife", "I'm grapeful for good company", "https://as1.ftcdn.net/v2/jpg/04/17/85/08/1000_F_417850826_ZQ98ggEKoZcqFjfLSgmBwYPHu1Tc4MGU.jpg");
        userProfile5.setId(5L);
        userProfile5.setUser(user5);
        profileRepository.save(userProfile5);
        user5.setUserProfile(userProfile5);

        User user6 = new User();
        user6.setId(6L);
        user6.setEmail("kelly@ga.com");
        user6.setPassword(encoder.encode("password"));
        userRepository.save(user6);
        UserProfile userProfile6 = new UserProfile();
        userProfile6.setId(6L);
        userProfile6.setUserName("KellyJ.");
        userProfile6.setTagline("I'm not a whiner, I'm a wine-er!");
        userProfile6.setImgSrc("https://as2.ftcdn.net/v2/jpg/04/07/34/77/1000_F_407347701_dejg4HjbiH2TLIYMkBUVdPsjVledmTGF.jpg");
        userProfile6.setUser(user6);
        profileRepository.save(userProfile6);
        user6.setUserProfile(userProfile);

        User user7 = new User();
        user7.setId(7L);
        user7.setEmail("grace@ga.com");
        user7.setPassword(encoder.encode("password"));
        userRepository.save(user7);
        UserProfile userProfile7= new UserProfile();
        userProfile7.setId(7L);
        userProfile7.setUserName("GrapeyGrace82");
        userProfile7.setTagline("Wine not? It's grape to have a glass!");
        userProfile7.setImgSrc("https://as2.ftcdn.net/v2/jpg/04/37/25/13/1000_F_437251307_OVA6rKqestcUEZvzSfTZZ6EL4yMrFGHU.jpg");
        userProfile7.setUser(user7);
        profileRepository.save(userProfile7);
        user7.setUserProfile(userProfile7);

        User user8 = new User();
        user8.setId(8L);
        user8.setEmail("chris@ga.com");
        user8.setPassword(encoder.encode("password"));
        userRepository.save(user8);
        UserProfile userProfile8= new UserProfile();
        userProfile8.setId(8L);
        userProfile8.setUserName("xXChrisXx");
        userProfile8.setTagline("I enjoy long walks to the wine aisle");
        userProfile8.setImgSrc("https://as1.ftcdn.net/v2/jpg/02/68/02/58/1000_F_268025877_L7AYwttgBpoXLEKS6JPuKJLqY1tNosL0.jpg");
        userProfile8.setUser(user8);
        profileRepository.save(userProfile8);
        user8.setUserProfile(userProfile8);
        System.out.println("Users created successfully!");

        User user9 = new User();
        user9.setId(9L);
        user9.setEmail("merideth@ga.com");
        user9.setPassword(encoder.encode("password"));
        userRepository.save(user9);
        UserProfile userProfile9= new UserProfile();
        userProfile9.setId(9L);
        userProfile9.setUserName("Meri2000");
        userProfile9.setTagline("I'm on cloud wine, enjoying life one sip at a time.");
        userProfile9.setImgSrc("https://as1.ftcdn.net/v2/jpg/01/31/03/78/1000_F_131037860_zqNyMmEIWs67DWpeNojr9kANiR4p6bTv.jpg");
        userProfile9.setUser(user9);
        profileRepository.save(userProfile9);
        user9.setUserProfile(userProfile9);
        System.out.println("Users created successfully!");


        User user10 = new User();
        user10.setId(10L);
        user10.setEmail("nancy@ga.com");
        user10.setPassword(encoder.encode("password"));
        userRepository.save(user10);
        UserProfile userProfile10= new UserProfile();
        userProfile10.setId(10L);
        userProfile10.setUserName("xFancyNancyx");
        userProfile10.setTagline("I'm on cloud wine, enjoying life one sip at a time.");
        userProfile10.setImgSrc("https://as1.ftcdn.net/v2/jpg/01/31/03/78/1000_F_131037860_zqNyMmEIWs67DWpeNojr9kANiR4p6bTv.jpg");
        userProfile10.setUser(user10);
        profileRepository.save(userProfile10);
        user10.setUserProfile(userProfile10);
        System.out.println("Users created successfully!");


        User user11 = new User();
        user11.setId(11L);
        user11.setEmail("danny@ga.com");
        user11.setPassword(encoder.encode("password"));
        userRepository.save(user11);
        UserProfile userProfile11= new UserProfile();
        userProfile11.setId(11L);
        userProfile11.setUserName("FunGuyDan");
        userProfile11.setTagline("My doctor says I need glasses");
        userProfile11.setImgSrc("https://as2.ftcdn.net/v2/jpg/01/45/96/95/1000_F_145969536_6jcZ7aZxoqurCniiG9s8G7k9cumGqJtm.jpg");
        userProfile11.setUser(user11);
        profileRepository.save(userProfile11);
        user11.setUserProfile(userProfile11);
        System.out.println("Users created successfully!");

        Wine wine = new Wine();
        wine.setId(1L);
        wine.setName("Cabernet Sauvignon");
        wine.setVitner("Château St. Michelle");
        wine.setVintage("2016");
        wine.setVarietal("Cabernet Sauvignon");
        wine.setTastingNotes("Rich blackcurrant, dark cherry, and cedar with hints of tobacco and vanilla.");
        wine.setAerationTime("60-90 minutes");
        wine.setGlassWare("Bordeaux glass");
        wine.setServingTemperature(65);
        wine.setPairing("Grilled steak, roasted lamb, aged cheddar.");
        wine.setImgSrc("https://potomacwines.com/image/cache/catalog/Red%206/CSM_cab-800x1000.jpg");
        wineRepository.save(wine);

        Wine wine2 = new Wine();
        wine2.setId(2L);
        wine2.setName("Chardonnay");
        wine2.setVitner("Kendall-Jackson");
        wine2.setVintage("2018");
        wine2.setVarietal("Chardonnay");
        wine2.setTastingNotes("Ripe apple, tropical fruit, and buttery vanilla with a creamy texture.");
        wine2.setAerationTime("none");
        wine2.setGlassWare("Chardonnay glass");
        wine2.setServingTemperature(55);
        wine2.setPairing("Grilled seafood, roasted chicken, creamy pasta dishes.");
        wine2.setImgSrc("https://www.brixwineandliquor.com/wp-content/uploads/2020/04/Kendall-Jackson-Vintners-Reserve-Chardonnay201-1.jpg");
        wineRepository.save(wine2);

        Wine wine3 = new Wine();
        wine3.setId(3L);
        wine3.setName("Michelle");
        wine3.setVitner("Château St. Michelle");
        wine3.setVintage("2017");
        wine3.setVarietal("Meiomi");
        wine3.setTastingNotes("Red cherry, raspberry, and earthy notes with a velvety texture.");
        wine3.setAerationTime("Decant for 30 minutes");
        wine3.setGlassWare("Burgundy glass");
        wine3.setServingTemperature(60);
        wine3.setPairing("Roasted duck, grilled salmon, mushroom risotto.");
        wine3.setImgSrc("https://cdn.shoplightspeed.com/shops/609238/files/5374896/meiomi-pinot-noir-2019-abv-137-750-ml.jpg");
        wineRepository.save(wine3);

        Wine wine4 = new Wine();
        wine4.setId(4L);
        wine4.setName("Bay's Blanc");
        wine4.setVitner("Cloudy Bay");
        wine4.setVintage("2020");
        wine4.setVarietal("Sauvignon Blanc");
        wine4.setTastingNotes("Crisp citrus, tropical fruit, and herbaceous flavors with vibrant acidity.");
        wine4.setAerationTime("none");
        wine4.setGlassWare("white wine glass");
        wine4.setServingTemperature(45);
        wine4.setPairing("Goat cheese, grilled asparagus, seafood salads.");
        wine4.setImgSrc("https://i0.wp.com/www.gordonswine.com/wp-content/uploads/product_images/product-15964-1677480158-2593.jpg?fit=600%2C600&ssl=1");
        wineRepository.save(wine4);

        Wine wine5 = new Wine();
        wine5.setId(5L);
        wine5.setName("Crest Grand Estates");
        wine5.setVitner("Columbia Crest");
        wine5.setVintage("2015");
        wine5.setVarietal("Merlot");
        wine5.setTastingNotes("Plum, blackberry, and mocha with soft tannins and a velvety finis");
        wine5.setAerationTime("60 minutes");
        wine5.setGlassWare("Bordeaux glass");
        wine5.setServingTemperature(65);
        wine5.setPairing("Roasted pork, grilled vegetables, tomato-based pasta dishes.");
        wine5.setImgSrc("https://www.b-21.com/labels/live/USCCME19BE.jpg");
        wineRepository.save(wine5);

        Wine wine6 = new Wine();
        wine6.setId(6L);
        wine6.setName("Chateau Cab");
        wine6.setVitner("Château St. Michelle");
        wine6.setVintage("2016");
        wine6.setVarietal("Cabernet Sauvignon");
        wine6.setTastingNotes("Rich blackcurrant, dark cherry, and cedar with hints of tobacco and vanilla.");
        wine6.setAerationTime("60");
        wine6.setGlassWare("Bordeaux glass");
        wine6.setServingTemperature(65);
        wine6.setPairing("Grilled steak, roasted lamb, aged cheddar.");
        wine6.setImgSrc("https://potomacwines.com/image/cache/catalog/Red%206/CSM_cab-800x1000.jpg");
        wineRepository.save(wine6);

        Wine wine7 = new Wine();
        wine7.setId(7L);
        wine7.setName("Château Miraval Rosé");
        wine7.setVitner("Château Miraval");
        wine7.setVintage("2019");
        wine7.setVarietal("Rosé Blend (Cinsault-based)");
        wine7.setTastingNotes("Crisp and elegant with flavors of strawberry, peach, and a hint of floral notes.");
        wine7.setAerationTime("Briefly swirl in the glass.");
        wine7.setGlassWare("Stemmed glass or wine tumbler");
        wine7.setServingTemperature(48);
        wine7.setPairing("Grilled seafood, salads, light appetizers.");
        wine7.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSt0il2w7Vzy6tK_kyHjAWuXGCHCuLII_lfTNEP7zqTkqQ3-usQnP-sR3Pk99s_gCTd-Y7gBuOcJGc&usqp=CAU&ec=48600112");
        wineRepository.save(wine7);

        Wine wine8 = new Wine();
        wine8.setId(8L);
        wine8.setName("The Prisoner");
        wine8.setVitner("The Prisoner Wine Company");
        wine8.setVintage("non-vintaged");
        wine8.setVarietal("Red Blend");
        wine8.setTastingNotes("Bold and complex flavors of dark fruit, spice, and a touch of oak.");
        wine8.setAerationTime("decant for 60 minutes");
        wine8.setGlassWare("Bordeaux glass");
        wine8.setServingTemperature(65);
        wine8.setPairing("Grilled steak, braised lamb, strong cheeses.");
        wine8.setImgSrc("https://bremerswineandliquor.com/wp-content/uploads/2018/06/the-prisoner.png");
        wineRepository.save(wine8);

        Wine wine9 = new Wine();
        wine9.setId(9L);
        wine9.setName("Whispering Angel Rosé");
        wine9.setVitner("Château d'Esclans");
        wine9.setVintage("2020");
        wine9.setVarietal("Rosé Blend (Grenache-based)");
        wine9.setTastingNotes("Refreshing with flavors of strawberry, citrus, and a hint of minerality.");
        wine9.setAerationTime("briefly swirl in glass");
        wine9.setGlassWare("Stemmed glass or wine tumbler");
        wine9.setServingTemperature(45);
        wine9.setPairing("Grilled seafood, salads, light appetizers.");
        wine9.setImgSrc("https://cdn.shopify.com/s/files/1/0848/5288/products/chateau-desclans-whispering-angel-rose-2019---750ml-26178125_e82814be-0561-40c5-98d0-a7a059aaf642.jpg?v=1591104369");
        wineRepository.save(wine9);

        Wine wine10 = new Wine();
        wine10.setId(10L);
        wine10.setName("Apothic Red");
        wine10.setVitner("Apothic Wines");
        wine10.setVintage("non-vintaged");
        wine10.setVarietal("Red Blend");
        wine10.setTastingNotes("Rich flavors of dark berries, vanilla, and hints of mocha.");
        wine10.setAerationTime("Briefly swirl in the glass");
        wine10.setGlassWare("Bordeaux glass");
        wine10.setServingTemperature(65);
        wine10.setPairing("Grilled meats, hearty stews, dark chocolate.");
        wine10.setImgSrc("https://isteam.wsimg.com/ip/14ef5299-ed5b-488b-9594-00fe33123a47/ols/83635_original/:/rs=w:600,h:600");
        wineRepository.save(wine10);

        Wine wine11 = new Wine();
        wine11.setId(11L);
        wine11.setName("Chardonnay");
        wine11.setVitner("Domaine Laroche");
        wine11.setVintage("2019");
        wine11.setVarietal("Chardonnay");
        wine11.setTastingNotes("Buttery with notes of tropical fruits, vanilla, and oak.");
        wine11.setAerationTime("30 minutes");
        wine11.setGlassWare("Chardonnay glass");
        wine11.setServingTemperature(50);
        wine11.setPairing("Grilled chicken, seafood pasta, creamy cheeses.");
        wine11.setImgSrc("https://www.sonomacutrer.com/wp-content/uploads/2021/01/USA_C-Sonoma-Cutrer-Les-Pierres-2020-769611300281-1024x1024.jpg");
        wineRepository.save(wine11);

        Wine wine12 = new Wine();
        wine12.setId(12L);
        wine12.setName("Merlot");
        wine12.setVitner("Clos du Bois");
        wine12.setVintage("2017");
        wine12.setVarietal("Merlot");
        wine12.setTastingNotes("Plum, blackberry, and cocoa with velvety tannins.");
        wine12.setAerationTime("45 minutes");
        wine12.setGlassWare("Bordeaux glass");
        wine12.setServingTemperature(60);
        wine12.setPairing("Roast beef, lamb chops, aged gouda.");
        wine12.setImgSrc("https://scene7.samsclub.com/is/image/samsclub/0008735642112_A");
        wineRepository.save(wine12);

        Wine wine13 = new Wine();
        wine13.setId(13L);
        wine13.setName("Pinot Noir");
        wine13.setVitner("Cloudy Bay");
        wine13.setVintage("2018");
        wine13.setVarietal("Pinot Noir");
        wine13.setTastingNotes("Red cherry, raspberry, and earthy undertones");
        wine13.setAerationTime("20 minutes");
        wine13.setGlassWare("Burgundy glass");
        wine13.setServingTemperature(55);
        wine13.setPairing("Salmon, roast duck, and brie cheese");
        wine13.setImgSrc("https://www.sparrowine.com/media/catalog/product/cache/4affeeb0391b580bb11202aa0f1726bb/2/4/24302-.jpg");
        wineRepository.save(wine13);

        Wine wine14 = new Wine();
        wine14.setId(14L);
        wine14.setName("Malbec");
        wine14.setVitner("Bodega Catena Zapata");
        wine14.setVintage("2015");
        wine14.setVarietal("Malbec");
        wine14.setTastingNotes("Intense blackberry, plum, and mocha flavors with a touch of spice.");
        wine14.setAerationTime("30 minutes");
        wine14.setGlassWare("Red wine glass");
        wine14.setServingTemperature(62);
        wine14.setPairing("Grilled steak, barbecue ribs, sharp cheddar.");
        wine14.setImgSrc("https://applejack.com/site/images/Bodega-Salentein-Malbec-Reserve-750-ml_1.png");
        wineRepository.save(wine14);

        Wine wine15 = new Wine();
        wine15.setId(15L);
        wine15.setName("Zinfandel");
        wine15.setVitner("Ravenswood");
        wine15.setVintage("2016");
        wine15.setVarietal("Zinfandel");
        wine15.setTastingNotes("Bold blackberry, raspberry, and black pepper spice with a hint of vanilla.");
        wine15.setAerationTime("45 minutes");
        wine15.setGlassWare("Red wine glass");
        wine15.setServingTemperature(64);
        wine15.setPairing("Barbecue ribs, spicy sausage, aged gouda.");
        wine15.setImgSrc("https://www.totalwine.com/dynamic/490x/media/sys_master/twmmedia/hc1/h8a/9382838304798.png");
        wineRepository.save(wine15);
        System.out.println("Wines created successfully!");


        //create post
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("Decadent!");
        post1.setTastingNotes("it was like having dessert with the whole meal, juicy and delicious. I appreciate the bold red fruit flavor");
        post1.setRating(8);
        post1.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQBoCFI1HW8g8oAjTCoVkaklI3IwDXrLFBMd9b-19BWg&usqp=CAU&ec=48600112");
        //set wine to post
        post1.setWine(wine);
        //set userProfile
        post1.setUserProfile(userProfile);
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("It wasn't my favorite");
        post2.setTastingNotes("It tasted a little too much like earth and dirt and less like fruit");
        post2.setRating(4);
        post2.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiORrXTZUTJSLunqHIRRSb_yIsBksUxtrufg&usqp=CAU");
        post2.setWine(wine);
        post2.setUserProfile(userProfile2);
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setId(3L);
        post3.setTitle("So so");
        post3.setTastingNotes("I expected a bigger flavor and pallet from this, it fell flat to me");
        post3.setRating(5);
        post3.setImgSrc("https://img.freepik.com/free-photo/smell-wine_1098-15584.jpg");
        post3.setWine(wine2);
        post3.setUserProfile(userProfile2);
        postRepository.save(post3);

        Post post4 = new Post();
        post4.setId(4L);
        post4.setTitle("Loved every sip!");
        post4.setTastingNotes("Deliciously smooth with rich flavors of dark chocolate and blackberry. We had grilled cheeseburgers for dinner and I found this went surprisingly well. Would pair again soon.");
        post4.setRating(7);
        post4.setImgSrc("https://images.unsplash.com/photo-1519671482749-fd09be7ccebf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8ZnJpZW5kcyUyMGRyaW5raW5nJTIwd2luZXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80");
        post4.setWine(wine15);
        post4.setUserProfile(userProfile2);
        postRepository.save(post4);
//
//        Post post5= new Post();
//        post5.setId(5L);
//        post5.setTitle("");
//        post5.setTastingNotes("");
//        post5.setRating(5);
//        post5.setImgSrc("");
//        post5.setWine();
//        post5.setUserProfile();
//        postRepository.save(post5);
//
//        Post post6= new Post();
//        post6.setId(5L);
//        post6.setTitle("");
//        post6.setTastingNotes("");
//        post6.setRating(5);
//        post6.setImgSrc("");
//        post6.setWine();
//        post6.setUserProfile();
//        postRepository.save(post6);
//
//        Post post7= new Post();
//        post5.setId(7L);
//        post5.setTitle("");
//        post5.setTastingNotes("");
//        post5.setRating(5);
//        post5.setImgSrc("");
//        post5.setWine();
//        post5.setUserProfile();
//        postRepository.save(post7);
//
//        Post post8= new Post();
//        post8.setId(8L);
//        post8.setTitle("");
//        post8.setTastingNotes("");
//        post8.setRating(5);
//        post8.setImgSrc("");
//        post8.setWine();
//        post8.setUserProfile();
//        postRepository.save(post8);
//
//        Post post9= new Post();
//        post9.setId(9L);
//        post9.setTitle("");
//        post9.setTastingNotes("");
//        post9.setRating(5);
//        post9.setImgSrc("");
//        post9.setWine();
//        post9.setUserProfile();
//        postRepository.save(post9);
//
//        Post post= new Post();
//        post.setId(L);
//        post.setTitle("");
//        post.setTastingNotes("");
//        post.setRating(5);
//        post.setImgSrc("");
//        post.setWine();
//        post.setUserProfile();
//        postRepository.save(post);
//
//        Post post= new Post();
//        post.setId(L);
//        post.setTitle("");
//        post.setTastingNotes("");
//        post.setRating(5);
//        post.setImgSrc("");
//        post.setWine();
//        post.setUserProfile();
//        postRepository.save(post);
//
//        Post post= new Post();
//        post.setId(L);
//        post.setTitle("");
//        post.setTastingNotes("");
//        post.setRating(5);
//        post.setImgSrc("");
//        post.setWine();
//        post.setUserProfile();
//        postRepository.save(post);
//
//        Post post= new Post();
//        post.setId(L);
//        post.setTitle("");
//        post.setTastingNotes("");
//        post.setRating(5);
//        post.setImgSrc("");
//        post.setWine();
//        post.setUserProfile();
//        postRepository.save(post);
//
//        Post post= new Post();
//        post.setId(L);
//        post.setTitle("");
//        post.setTastingNotes("");
//        post.setRating(5);
//        post.setImgSrc("");
//        post.setWine();
//        post.setUserProfile();
//        postRepository.save(post);

        System.out.println("Posts have been created!");

        //SET THE POSTS TO A LIST TO THE USER PROFILE
        List<Post> userProfile1posts = new ArrayList<>();
        userProfile1posts.add(post1);
        userProfile1posts.add(post2);
        userProfile2.setUserPosts(userProfile1posts);

        List<Post> userProfile2posts = new ArrayList<>();
        userProfile2posts.add(post3);
        userProfile2.setUserPosts(userProfile2posts);

        //SET THE POSTS TO A LIST TO THE WINE
        List<Post> wine1posts = new ArrayList<>();
        wine1posts.add(post1);
        wine1posts.add(post2);
        wine1posts.add(post3);
        wine.setPostsAboutThisWine(wine1posts);
    }
}
