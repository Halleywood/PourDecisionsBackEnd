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
        user.setEmail("suresh@ga.com");
        user.setPassword(encoder.encode("suresh"));
        userRepository.save(user);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1L);
        userProfile.setUserName("Suresh");
        userProfile.setTagline("I'm not wine-ing, I'm just expressing my grape expectations");
        userProfile.setImgSrc("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwwvTaE5LXDzLVEMnRNmPdJ_sYdSTdhWVuNYycmRaQeQ&usqp=CAU&ec=48600112");
        userProfile.setUser(user);
        profileRepository.save(userProfile);
        user.setUserProfile(userProfile);

        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("kelsey@ga.com");
        user2.setPassword(encoder.encode("kelsey"));
        userRepository.save(user2);
        UserProfile userProfile2 = new UserProfile("Kelso", "I'm vine and dandy, thanks for asking", "https://t4.ftcdn.net/jpg/05/33/97/31/360_F_533973132_DYTYD0n2Qx0oeQTxNZOSCUNkFsfwNNhN.jpg");
        userProfile2.setId(2L);
        userProfile2.setUser(user2);
        profileRepository.save(userProfile2);
        user2.setUserProfile(userProfile2);

        User user3 = new User();
        user3.setId(3L);
        user3.setEmail("john@ga.com");
        user3.setPassword(encoder.encode("john"));
        userRepository.save(user3);
        UserProfile userProfile3 = new UserProfile("John", "I'm aging like a fine wine, getting better with time", "https://media.istockphoto.com/id/1330285227/vector/male-avatar-icon.jpg?s=612x612&w=0&k=20&c=KFUDN9KXhdg7o2UENX-02Z9pXoU25zcOMT_hHTE4qvU=");
        userProfile3.setId(3L);
        userProfile3.setUser(user3);
        profileRepository.save(userProfile3);
        user3.setUserProfile(userProfile3);

        User user4 = new User();
        user4.setId(4L);
        user4.setEmail("kenny@ga.com");
        user4.setPassword(encoder.encode("kenny"));
        userRepository.save(user4);
        UserProfile userProfile4 = new UserProfile("Kenny G", "It's time to wine down and relax", "https://img.freepik.com/premium-vector/icon-man-s-face-with-light-skin_238404-1006.jpg");
        userProfile4.setId(4L);
        userProfile4.setUser(user4);
        profileRepository.save(userProfile4);
        user4.setUserProfile(userProfile4);

        User user5 = new User();
        user5.setId(5L);
        user5.setEmail("alice@ga.com");
        user5.setPassword(encoder.encode("alice"));
        userRepository.save(user5);
        UserProfile userProfile5 = new UserProfile("Alice", "I'm grapeful for good company", "https://www.shutterstock.com/image-vector/faceless-woman-face-icon-female-260nw-2263344341.jpg");
        userProfile5.setId(5L);
        userProfile5.setUser(user5);
        profileRepository.save(userProfile5);
        user5.setUserProfile(userProfile5);

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
        post2.setTitle("Meh");
        post2.setTastingNotes("It tasted a little too much like earth and dirt and less like fruit");
        post2.setRating(4);
        post2.setImgSrc("https://sonomawinegarden.com/wp-content/uploads/2022/09/More-About-Telling-If-a-Wine-Is-Bad.jpg");
        post2.setWine(wine);
        post2.setUserProfile(userProfile);
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setId(3L);
        post3.setTitle("So so");
        post3.setTastingNotes("I expected a bigger flavor and pallet from this, it fell flat to me");
        post3.setRating(5);
        post3.setImgSrc("https://img.freepik.com/free-photo/smell-wine_1098-15584.jpg");
        post3.setWine(wine);
        post3.setUserProfile(userProfile2);
        postRepository.save(post3);


        System.out.println("Posts have been created!");

        //SET THE POSTS TO A LIST TO THE USER PROFILE
        List<Post> userProfile1posts = new ArrayList<>();
        userProfile1posts.add(post1);
        userProfile1posts.add(post2);
        userProfile.setUserPosts(userProfile1posts);

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
