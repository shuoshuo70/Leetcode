package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
    private static int timeSamp = 0;
    Map<Integer, User> users;
    class Tweet {
        int tweetId;
        int time;
        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            time = timeSamp++;
        }
        public Integer getTime() {
            return time;
        }
        
        public int getId() {
            return tweetId;
        }
    }

    class User {
        int userId;
        Set<Integer> follows;
        List<Tweet> tweets;
        User(int userId) {
            this.userId = userId;
            follows = new HashSet<>();
            follows.add(userId);
            tweets = new ArrayList<>();
        }
        
        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweets.add(tweet);
        }
        
        public Set<Integer> getFollows() {
            return follows;
        }
        
        public List<Tweet> getTweets() {
            return tweets;
        }
        
        public void follow(int followerId) {
            follows.add(followerId);
        }
        
        public void unFollow(int followerId) {
            if(!follows.contains(followerId)) return;
            follows.remove((Integer)followerId);
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        users.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)) return new ArrayList<>();
        User u = users.get(userId);
        Set<Integer> follows =u.getFollows();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t1.getTime() - t2.getTime();
            }
        });
        
        for(int followeeId : follows) {
            List<Tweet> tweets = users.get(followeeId).getTweets();
            for(int i=tweets.size()-1; i>=0; i--) {
                if(pq.size() == 10) {
                    if(pq.peek().getTime() < tweets.get(i).getTime()) {
                        pq.poll();
                    } else break;
                }
                pq.offer(tweets.get(i));
            }
        }
        
        List<Integer> news = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            news.add(pq.poll().getId());
        }
        Collections.reverse(news);
        return news;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || followerId == followeeId) return;
        users.get(followerId).unFollow(followeeId);
    }
    
    public static void main(String[] args) {
    	Twitter solution = new Twitter();
    	solution.follow(1, 5);
    	System.out.println(solution.getNewsFeed(1));
    }
    
}



/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
