import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

    private static int timeStamp=0;

    //user class to represent each user in twitter
    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id){
            this.id=id;
            followed = new HashSet<>();
            follow(id); // use should follow themself
            tweetHead=null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            if(id!=this.id){
                followed.remove(id);
            }
        }

        public void post(int id){
            Tweet newTweet = new Tweet(id);
            newTweet.next=tweetHead;
            tweetHead=newTweet;
        }
    }

    //tweet class to represent each tweet
    private class  Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id){
            this.id=id;
            this.time= timeStamp++;
            next=null;
        }
    }


    //user map
    private Map<Integer, User> userMap;
    
    // initialize your data structure here

    public DesignTwitter(){
        userMap = new HashMap<>();
    }

    //compose a new tweet
    public void postTweet(int userid,int tweetid){
        if(!userMap.containsKey(userid)){
            User newUser = new User(userid);
            userMap.put(userid,newUser);
        }
        userMap.get(userid).post(tweetid);
    }

    // retrive the 10 most recent tweet ids in the user's news feed.
    // each item in the news feed must be posted by users who the user follwed or by the user themselfs
    // tweet must be ordered from the most recent to least recent

    public List<Integer> getNewsFed(int userid){
        var newsFeed = new LinkedList<Integer>(); //used to store news feed
        if(!userMap.containsKey(userid)) return newsFeed; // if he do not have news feed return empty

        Set<Integer> followedUsers = userMap.get(userid).followed; //all info of user that are followed by the user
        var tweetHeap = new PriorityQueue<Tweet>((followedUsers.size()),(a,b) -> b.time-a.time);

        for(int user: followedUsers){
            Tweet tweet = userMap.get(user).tweetHead;// all the tweets the users follower hav  `e created   
            if(tweet!=null){
                tweetHeap.add(tweet);
            }
        }

        //check if the tweet is top 10
        int count=0;
        while(!tweetHeap.isEmpty() && count<10){
            Tweet tweet = tweetHeap.poll();
            newsFeed.add(tweet.id);
            count++;
            if(tweet.next!=null){
                tweetHeap.add(tweet.next);
            }
        }
        return newsFeed;
    }

    //followers follow  a followee
    public void follow(int followerid, int followeeid){
        if(!userMap.containsKey(followerid)){
            User newuser = new User(followerid);
            userMap.put(followerid,newuser);
        }

        if(!userMap.containsKey(followeeid)){
            User newuser = new User(followeeid);
            userMap.put(followeeid,newuser);
        }
        userMap.get(followerid).follow(followeeid);
    }

    //follower unfollow a followee
    public void unfollow(int followerid, int followeeid){
        if(userMap.containsKey(followerid) && followerid != followeeid){
            userMap.get(followerid).unfollow(followeeid); 
        }
    }


   public static void main(String[] args) {

        DesignTwitter twitter = new DesignTwitter();

        twitter.postTweet(1, 101);

        twitter.postTweet(1, 102);

        twitter.postTweet(2, 201);

        twitter.follow(1, 2);

        System.out.println( "News Feed of User 1:");

        System.out.println(twitter.getNewsFed(1));

        twitter.unfollow(1, 2);

        System.out.println( "After Unfollow:");

        System.out.println(twitter.getNewsFed(1));
    } 
}
