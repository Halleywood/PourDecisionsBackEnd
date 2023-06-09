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
        UserProfile userProfile5 = new UserProfile("Lindsay", "I'm grapeful for good company", "https://as1.ftcdn.net/v2/jpg/04/17/85/08/1000_F_417850826_ZQ98ggEKoZcqFjfLSgmBwYPHu1Tc4MGU.jpg");
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
        post1.setRating(7);
        post1.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQBoCFI1HW8g8oAjTCoVkaklI3IwDXrLFBMd9b-19BWg&usqp=CAU&ec=48600112");
        //set wine to post
        post1.setWine(wine);
        //set userProfile
        post1.setUserProfile(userProfile6);
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
        post4.setImgSrc("");
        post4.setWine(wine15);
        post4.setUserProfile(userProfile6);
        postRepository.save(post4);

        Post post5= new Post();
        post5.setId(5L);
        post5.setTitle("I can't wait to try this again");
        post5.setTastingNotes("I found this to be full of red fruit, not to sweet and not too jammy. It had a full mouth feel without being too dry either?!");
        post5.setRating(8);
        post5.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqB3692dl5macSgRO47u3ZJq1eVU4A3KA8cQ&usqp=CAU");
        post5.setWine(wine);
        post5.setUserProfile(userProfile6);
        postRepository.save(post5);

        Post post6= new Post();
        post6.setId(6L);
        post6.setTitle("Way too Oaky");
        post6.setTastingNotes("I thought this would be more fruit forward, and less oak and smoke notes too it. I did not enjoy this at all. ");
        post6.setRating(3);
        post6.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5qWerkb4CSGqFyKZeklwAhfanBn_vRR3djoRx32Fca5aNZNn2tkfhfR5m3SjZAltyg3U&usqp=CAU");
        post6.setWine(wine2);
        post6.setUserProfile(userProfile5);
        postRepository.save(post6);

        Post post7= new Post();
        post5.setId(7L);
        post5.setTitle("Not terrible");
        post5.setTastingNotes("I guess I thought this would be bigger and drier. It did not hold up to the steak I had it with at all. This would be a nice drinking wine but would not try and pair it with food again.  Overall the flavors weren't too bad. Strawberry, Licorice, a hint of Oak and tobacco. ");
        post5.setRating(5);
        post5.setImgSrc("data:image/jpeg;base64,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");
        post5.setWine(wine);
        post5.setUserProfile(userProfile4);
        postRepository.save(post7);

        Post post8= new Post();
        post8.setId(8L);
        post8.setTitle("Great flavor, great nose!");
        post8.setTastingNotes("This was so enjoyable to drink. My husband who doesn't really care for wine even said so. Just the right balance of fruit, minerality, and fresh herbs to make it pair nicely with our appetizers and main course");
        post8.setRating(9);
        post8.setImgSrc("https://www.shutterstock.com/image-photo/ethnic-friends-bar-drinking-wine-260nw-350851181.jpg");
        post8.setWine(wine2);
        post8.setUserProfile(userProfile7);
        postRepository.save(post8);

        Post post9= new Post();
        post9.setId(9L);
        post9.setTitle("This is it!");
        post9.setTastingNotes("100 delicious!");
        post9.setRating(10);
        post9.setImgSrc("https://previews.123rf.com/images/microgen/microgen1607/microgen160700230/61055777-friends-drinking-wine-in-restaurant.jpg");
        post9.setWine(wine);
        post9.setUserProfile(userProfile10);
        postRepository.save(post9);

        Post post10 = new Post();
        post10.setId(10L);
        post10.setTitle("A winner!");
        post10.setTastingNotes("I need to bring this to the inlaws to try! It was perfect! A crispy, fresh wine that wasn't dry at all");
        post10.setRating(7);
        post10.setImgSrc("https://s3.envato.com/files/ee0716db-544a-410a-9e68-8a6cce92093c/inline_image_preview.jpg");
        post10.setWine(wine8);
        post10.setUserProfile(userProfile5);
        postRepository.save(post10);

        Post post11= new Post();
        post11.setId(11L);
        post11.setTitle("Not for me");
        post11.setTastingNotes("unfortunately this was alll smoke, tobacco, and wood notes. I didn't pick up any fruit at all. Mental not to stay away from Washington Pinots! ");
        post11.setRating(5);
        post11.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiAGezPHWprmkrxhQA81KOeat2DYCOSA86Iw&usqp=CAU");
        post11.setWine(wine9);
        post11.setUserProfile(userProfile6);
        postRepository.save(post11);
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
