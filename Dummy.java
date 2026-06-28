import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dummy{
    private int timeStamp=0;

    class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id){
            this.id=id;
            followed = new HashSet<>();
            follow(id);
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
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    private class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id){
            this.id=id;
            this.time = timeStamp++;
            next=null;
        }
    }

    private Map<Integer, User> userMap;

    public Dummy(){
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId){
        if(!userMap.containsKey(userId)){
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId, int tweetId){
        var newsFeed = new LinkedList<Integer>();
        if(!userMap.containsKey(userId)) return newsFeed;

        Set<Integer> followedByUser = userMap.get(userId).followed;
        var tweetHeap = new PriorityQueue<Tweet>(followedByUser.size(),(a,b) -> b.time - a.time);

        for(int user:followedByUser){
            Tweet tweet = userMap.get(user).tweetHead;
            if(tweet!=null){
                tweetHeap.add(tweet);
            }
        }

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

    public void follow(int followerId, int followeeeId){
        if(!userMap.containsKey(followerId)){
            User newUser = new User(followerId);
            userMap.put(followerId,newUser);
        }

        if(!userMap.containsKey(followeeeId)){
            User newUser = new User(followeeeId);
            userMap.put(followeeeId,newUser);
        }
        userMap.get(followerId).follow(followeeeId);
    }
    
}