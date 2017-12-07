package com.example.badge.androidapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN ACTIVITY:" ;
    Button signin, signup;
    List<Quote> ql = new ArrayList<>();
    TextView quoteV;

    DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    Quote q = new Quote();
    FireBase fb = new FireBase();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = (Button)   findViewById(R.id.signin);
        signup = (Button)   findViewById(R.id.signup);
        quoteV = (TextView) findViewById(R.id.quote);


        System.out.println("Hello I like to bake Donuts");


        QuoteCategory quoteCategory = getRandomCategory();
        getQuotes(quoteCategory);



//        //Inspiration    *******************************************************************//
//        q.setQuoteText("The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.");
//        q.setQuoteSource("Helen Keller");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The best preparation for tomorrow is doing your best today.");
//        q.setQuoteSource("H. Jackson Brown, Jr.");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.");
//        q.setQuoteSource("Swami Sivananda");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "I can’t change the direction of the wind, but I can adjust my sails to always reach my destination.");
//        q.setQuoteSource("Jimmy Dean");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Start by doing what’s necessary; then do what’s possible; and suddenly you are doing the impossible.");
//        q.setQuoteSource("Francis of Assisi");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("We must let go of the life we have planned, so as to accept the one that is waiting for us.");
//        q.setQuoteSource("Joseph Campbell");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Try to be a rainbow in someone’s cloud.");
//        q.setQuoteSource("Maya Angelou");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Happiness is not something you postpone for the future; it is something you design for the present.");
//        q.setQuoteSource("Jim Rohn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("It is during our darkest moments that we must focus to see the light.");
//        q.setQuoteSource("Aristotle");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Nothing is impossible, the word itself says ‘I’m possible’!");
//        q.setQuoteSource("Audrey Hepburn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Change your thoughts and you change the world.");
//        q.setQuoteSource("Norman Vincent Peale");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.");
//        q.setQuoteSource("Steve Jobs");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Today I choose life. Every morning when I wake up I can choose joy, happiness, negativity, pain... To feel the freedom that comes from being able to continue to make mistakes and choices - today I choose to feel life, not to deny my humanity but embrace it.");
//        q.setQuoteSource("Kevyn Aucoin");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Believe you can and you’re halfway there.");
//        q.setQuoteSource("Theodore Roosevelt");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("My mission in life is not merely to survive, but to thrive; and to do so with some passion, some compassion, some humor, and some style.");
//        q.setQuoteSource("Maya Angelou");
//        ql.add(q);
//
//
//        for (Quote a: ql){
//            fb.addInspirationalQ(a);
//        }
//
//
//
//
//
//        //Fitness    *******************************************************************//
//        ql = new ArrayList<>();
//
//        q.setQuoteText("Take care of your body. It's the only place you have to live. ");
//        q.setQuoteSource("Jim Rohn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("To enjoy the glow of good health, you must exercise");
//        q.setQuoteSource("Gene Tunney");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Physical fitness is not only one of the most important keys to a healthy body, it is the basis of dynamic and creative intellectual activity.");
//        q.setQuoteSource("John F. Kennedy");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "The purpose of training is to tighten up the slack, toughen the body, and polish the spirit.");
//        q.setQuoteSource("Morihei Ueshiba");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Fitness is not about being better than someone else... It's about being better than you used to be.");
//        q.setQuoteSource("Khloe Kardashian");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("For me, fitness is not just about hitting the gym; it is also about an inner happiness and an overall well-being.");
//        q.setQuoteSource("Rakul Preet Singh");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Time and health are two precious assets that we don't recognize and appreciate until they have been depleted. ");
//        q.setQuoteSource("Denis Waitley");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The human body is the best picture of the human soul.");
//        q.setQuoteSource("Ludwig Wittgenstein");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The reason I exercise is for the quality of life I enjoy.");
//        q.setQuoteSource("Kenneth H. Cooper");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("In fitness, there are no short cuts. It involves immense discipline and hard work.");
//        q.setQuoteSource("Mahesh Babu");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The mind is the most important part of achieving any fitness goal. Mental change always comes before physical change. ");
//        q.setQuoteSource("Matt McGorry");
//        ql.add(q);
//
//
//        //Add to the exercise category
//        for (Quote a: ql){
//            fb.addFitnessQ(a);
//        }
//
//
//
//
//
//        //Funny    *******************************************************************//
//        ql = new ArrayList<>();
//
//        q = new Quote();
//        q.setQuoteText("Do not take life too seriously. You will never get out of it alive.");
//        q.setQuoteSource("Elbert Hubbard");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Always remember that you are absolutely unique. Just like everyone else.");
//        q.setQuoteSource("Margaret Mead");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "A day without sunshine is like, you know, night.");
//        q.setQuoteSource("Steve Martin");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("People who think they know everything are a great annoyance to those of us who do.");
//        q.setQuoteSource("Isaac Asimov");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Happiness is having a large, loving, caring, close-knit family in another city.");
//        q.setQuoteSource("George Burns");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("A woman's mind is cleaner than a man's: She changes it more often.");
//        q.setQuoteSource("Oliver Herford");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Roses are red, violets are blue, I'm schizophrenic, and so am I.");
//        q.setQuoteSource("Oscar Levant");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("I'm sorry, if you were right, I'd agree with you.");
//        q.setQuoteSource("Robin Williams");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Age is something that doesn't matter, unless you are a cheese.");
//        q.setQuoteSource("Luis Bunuel");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("I found there was only one way to look thin: hang out with fat people.");
//        q.setQuoteSource("Rodney Dangerfield");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Life is hard. After all, it kills you.");
//        q.setQuoteSource("Katharine Hepburn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("If women ran the world we wouldn't have wars, just intense negotiations every 28 days.");
//        q.setQuoteSource("Robin Williams");
//        ql.add(q);
//
//        // ADD to DB
//        for (Quote a: ql){
//            fb.addFunnyQ(a);
//        }
//
//
//
//
//        //Wisdom    *******************************************************************//
//        ql = new ArrayList<>();
//
//        q = new Quote();
//        q.setQuoteText("For beautiful eyes, look for the good in others; for beautiful lips, speak only words of kindness; and for poise, walk with the knowledge that you are never alone.");
//        q.setQuoteSource("Audrey Hepburn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Work like you don't need the money. Love like you've never been hurt. Dance like nobody's watching.");
//        q.setQuoteSource("Satchel Paige");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "he journey of a thousand miles begins with one step.");
//        q.setQuoteSource("Lao Tzu");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("It's not what you look at that matters, it's what you see.");
//        q.setQuoteSource("Henry David Thoreau");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("o enjoy good health, to bring true happiness to one's family, to bring peace to all, one must first discipline and control one's own mind. If a man can control his mind he can find the way to Enlightenment, and all wisdom and virtue will naturally come to him.");
//        q.setQuoteSource("Buddha");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("In every walk with nature one receives far more than he seeks.");
//        q.setQuoteSource("John Muir");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Honesty is the first chapter in the book of wisdom.");
//        q.setQuoteSource("Thomas Jefferson");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Do not go where the path may lead, go instead where there is no path and leave a trail.");
//        q.setQuoteSource("Ralph Waldo Emerson");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Discipline is the bridge between goals and accomplishment.");
//        q.setQuoteSource("Jim Rohn");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The only true wisdom is in knowing you know nothing.");
//        q.setQuoteSource("Socrates");
//        ql.add(q);
//
//
//        for (Quote a: ql){
//            fb.addWisdomQ(a);
//        }
//
//
//
//
//        //Love    *******************************************************************//
//        ql = new ArrayList<>();
//
//
//        q = new Quote();
//        q.setQuoteText("There is only one happiness in this life, to love and be loved.");
//        q.setQuoteSource("George Sand");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Love yourself. It is important to stay positive because beauty comes from the inside out.");
//        q.setQuoteSource("Jenn Proske");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "Being deeply loved by someone gives you strength, while loving someone deeply gives you courage.");
//        q.setQuoteSource("Lao Tzu");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Love is when the other person's happiness is more important than your own.");
//        q.setQuoteSource("H. Jackson Brown, Jr.");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Friends show their love in times of trouble, not in happiness.");
//        q.setQuoteSource("Euripides");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Let us always meet each other with smile, for the smile is the beginning of love.");
//        q.setQuoteSource("Mother Teresa");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Where there is love there is life.");
//        q.setQuoteSource("Mahatma Gandhi");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Immature love says: 'I love you because I need you.' Mature love says 'I need you because I love you.'");
//        q.setQuoteSource("Erich Fromm");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Love is friendship that has caught fire. It is quiet understanding, mutual confidence, sharing and forgiving. It is loyalty through good and bad times. It settles for less than perfection and makes allowances for human weaknesses.");
//        q.setQuoteSource("Ann Landers");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The most important thing in the world is family and love.");
//        q.setQuoteSource("John Wooden");
//        ql.add(q);
//
//
//        for (Quote a: ql){
//            fb.addLoveQ(a);
//        }
//
//
//
//
//        //Life    *******************************************************************//
//        ql = new ArrayList<>();
//
//        q = new Quote();
//        q.setQuoteText("Only I can change my life. No one can do it for me.");
//        q.setQuoteSource("Carol Burnett");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Life is 10% what happens to you and 90% how you react to it.");
//        q.setQuoteSource("Charles R. Swindoll");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText( "In three words I can sum up everything I've learned about life: it goes on.");
//        q.setQuoteSource("Robert Frost");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("The greatest gift of life is friendship, and I have received it.");
//        q.setQuoteSource("Hubert H. Humphrey");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.");
//        q.setQuoteSource("Buddha");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Life isn't about finding yourself. Life is about creating yourself.");
//        q.setQuoteSource("George Bernard Shaw");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("We must let go of the life we have planned, so as to accept the one that is waiting for us.");
//        q.setQuoteSource("Joseph Campbell");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Learn to enjoy every minute of your life. Be happy now. Don't wait for something outside of yourself to make you happy in the future. Think how really precious is the time you have to spend, whether it's at work or with your family. Every minute should be enjoyed and savored.");
//        q.setQuoteSource("Earl Nightingale");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Smile in the mirror. Do that every morning and you'll start to see a big difference in your life.");
//        q.setQuoteSource("Yoko Ono");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Do not take life too seriously. You will never get out of it alive.");
//        q.setQuoteSource("Elbert Hubbard");
//        ql.add(q);
//        q = new Quote();
//        q.setQuoteText("Elbert Hubbard");
//        q.setQuoteSource("Omar Khayyam");
//        ql.add(q);
//
//        for (Quote a: ql){
//            fb.addLifeQ(a);
//        }


        //User user  = new User("badgero1234@icloud.com", "badgero1234@icloud.com", "2089700157", qcList, "weekly" );

        //fb.addNewUser(user);


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });
    }


    private QuoteCategory getRandomCategory() {
        //Create a new random number with a range of 0 - 5
        Random rand = new Random();
        int min = 0;
        int max = 5;

        int i = rand.nextInt((max - min) + 1);
        QuoteCategory quoteCategory = null;

        switch (i) {
            case 0:
                quoteCategory = quoteCategory.Wisdom;
                break;
            case 1:
                quoteCategory = quoteCategory.Love;
                break;
            case 2:
                quoteCategory = quoteCategory.Inspiration;
                break;
            case 3:
                quoteCategory = quoteCategory.Funny;
                break;
            case 4:
                quoteCategory = quoteCategory.Life;
                break;
            case 5:
                quoteCategory = quoteCategory.Fitness;
                break;
            default:
                try {
                    throw new Exception("Invalid Category");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        return quoteCategory;
    }


    private void getQuotes(QuoteCategory category) {
        mDataBase = FirebaseDatabase.getInstance().getReference();

        switch (category) {
            case Wisdom:
                ql = fb.getWisdomQuotes();
                break;
            case Love:
                ql = fb.getLoveQuotes();
                break;
            case Inspiration:
                ql = fb.getInspirationalQuotes();
                break;
            case Life:
                ql = fb.getLifeQuotes();
                break;
            case Fitness:
                ql = fb.getFitnessQuotes();
                break;
            case Funny:
                ql = fb.getFunnyQuotes();
                break;
            default:
                try {
                    throw new Exception("Invalid Category");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }



        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int max = ql.size();
                int min = 0;

                Random rand = new Random();

                final int i = rand.nextInt((max - min));
                try {
                    q = ql.get(i);
                    quoteV.setText(q.getQuoteText());
                }catch (Exception e) {
                    Log.d(TAG, "onDataChange: " + e.toString());
                }

                // Do all of the logic here .... If you are setting some text then do it here.
                // So in the browse set a thing that will switch between the quote topics.
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




        public void login(View view) {
            try {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
            catch (Exception e) {
                Log.d("Main Activity TRANSFER", e.toString());
            }
        }

        public void signUp(View view) {
            try {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
            catch (Exception e) {
                Log.d("Main Activity TRANSFER", e.toString());
            }
        }
    }

