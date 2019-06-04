package com.guoyunyu.jiansheng.my.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * LambdaTest
 * <p>
 * 1   stream并没有改变本身的集合结构，但是foreach会改变     转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象
 * 2   如果lambda表达式的参数只有一个，则小括号可以省略
 * 3   如果lambda只包含一条语句，箭头后的大括号也可以省略
 * 4   方法引用写法 Class or instance :: method
 * 5   filter 过滤，和map没有先后顺序
 * 6   map 一对一转换
 * 6   collection.foreach(System.out::println)  = collection.foreach(x -> System.out.println(x))
 * </p>
 * <p>
 * <p>
 * map 对元素进行转换
 * filter 对元素进行过滤 条件boolean
 * distinct 对元素进行去重
 * limit: 对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素
 * </p>
 * <p>
 * <p>
 * 汇聚操作 reduce
 * </p>
 *
 * @author Yongjian.Liu
 * @date 2018/11/28 11:06
 */
public class LambdaTest {


    /**
     * 简化匿名内部类
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 11:15
     */
    @Test
    public void test1() {
        Thread td_old = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test1 old");
            }
        });

        td_old.start();
        //new
        Thread td_new = new Thread(() -> System.out.println("test1 new"));
        td_new.start();

    }


    /**
     * 简化compare比较器
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 13:38
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList(new String[]{"c", "a", "b", "e", "d"});
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        //new
        List<String> list_new = Arrays.asList(new String[]{"c", "a", "b", "e", "d"});
        Collections.sort(list_new, (str1, str2) -> str1.compareTo(str2));
        System.out.println(list_new);
    }

    
    /**
     * 多条件比较器的实现
     *
     * @author Yongjian.Liu
     * @date 2019/4/4 13:43
     */
    @Test
    public void multCompareTest(){
        List<String> list = Arrays.asList(new String[] {"hello","welcome","big","synchronized"});
        list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList()).forEach(System.out::println);

        List<String> list2 = Arrays.asList(new String[] {"hello","welcome","big","synchronized"});
        list2.sort(Comparator.comparingInt(String::length));
        System.out.println(list2);


    }


    /**
     * 简化集合遍历与替换
     * <p>
     * 如果lambda表达式的参数只有一个，则小括号可以省略
     * 如果lambda只包含一条语句，箭头后的大括号也可以省略
     * 函数式编程可以没有返回值，也可以有返回值。如果有返回值时，需要代码段的最后一句通过return的方式返回对应的值
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 13:50
     */
    @Test
    public void test3() {
        List<String> proNames = Arrays.asList(new String[]{"HELLO", "WORLD"});

//        List<String> laterNames = proNames.stream().map(ele -> ele.toLowerCase()).collect(Collectors.toList());
        List<String> laterNames = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(laterNames);
        System.out.println(proNames);

        List<String> subNames = proNames.stream().map((ele) -> {
            ele = ele.toUpperCase().substring(1);
            return ele;
        }).collect(Collectors.toList());
        System.out.println(subNames);
    }


    /**
     * 遍历map
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 14:09
     */
    @Test
    public void test4() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("key1", "value1");
        paramMap.put("key2", "value2");

        paramMap.forEach((key, value) -> System.out.println(key + value));


    }


    /**
     * 过滤filter
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 15:49
     */
    @Test
    public void test5() {
        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 8);
        Long countNum = nums.stream().filter(num -> num != null).count();
        System.out.println(countNum);
        nums.forEach(System.out::println);
    }


    /**
     * 去重distinct
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 15:49
     */
    @Test
    public void test6() {
        List<Integer> orgList = Arrays.asList(new Integer[]{1, 3, 5, 7, 3, 5, 9});
        List<Integer> newList = orgList.stream().distinct().collect(Collectors.toList());
        orgList.forEach(System.out::print);
        newList.forEach(System.out::print);

    }

    /**
     * limit
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 15:49
     */
    @Test
    public void test8() {
        List<Integer> orgList = Arrays.asList(new Integer[]{1, 3, 5, 7, 3, 5, 9});
        List<Integer> newList = orgList.stream().limit(3).collect(Collectors.toList());
        orgList.forEach(System.out::print);
        newList.forEach(System.out::print);

    }


    /**
     * reduce给一个起始值
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 16:50
     */
    @Test
    public void test9() {
        List<Integer> numList = Arrays.asList(new Integer[]{1, 3, 5, 7, 9, 13, 11});
        Integer result = numList.stream().reduce(0, Integer::sum);
        System.out.println(result);


        int count = numList.stream().mapToInt(ele -> ele).sum();
        System.out.println(count);

    }


    /**
     * flatMap将多个流转化成一个流
     *
     * @author Yongjian.Liu
     * @date 2018/11/28 16:36
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList(new String[]{"HELLO", "WORLD"});

        //第一个map返回的是一个数组，需要在对这个数组进行stream来获取一个字节流  Arrays.stream接收一个数组返回一个流
//        System.out.println(list.stream().map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).collect(Collectors.toList()));


        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));


    }


    /**
     * list 转map
     *
     * @author Yongjian.Liu
     * @date 2018/12/19 14:54
     */
    @Test
    public void test10() {
        User user1 = new User("zhangsan", 15);
        User user2 = new User("lisi", 14);
        User user3 = new User("wangwu", 16);
        User user4 = new User("liliu", 14);
        List<User> userList = Arrays.asList(user1, user2, user3, user4);
        //新值 覆盖 旧值
        Map<Integer, User> resultMap = userList.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (x1, x2) -> x2));
        resultMap.forEach((key, value) -> System.out.println(key + value.getName()));

        //group map
        Map<Integer, List<User>> groupMap = userList.stream().collect(Collectors.groupingBy(User::getAge));
        groupMap.forEach((age, list) -> {
            System.out.print(age);
            list.forEach(curUser -> System.out.println(curUser.getName()));
        });

    }


    /**
     * 分割字母flatMap 的输出值R必须是一个stream
     * 适合收集 list<entity> 并且entity中含有list的嵌套场景
     *
     * @author Yongjian.Liu
     * @date 2018/12/19 16:42
     */
    @Test
    public void test11() {
        List<String> strList = Arrays.asList(new String[]{"hello", "world"});
        strList.stream().flatMap(curStr -> Stream.of(curStr.split(""))).forEach(System.out::println);
        strList.stream().map(cur -> cur.split("")).flatMap(cur -> Arrays.stream(cur)).forEach(System.out::println);
    }


    /**
     * Stream.of操作基础类型集合有坑（一可变参数 一对象入参）
     *
     * @author Yongjian.Liu
     * @date 2018/12/19 17:22
     */
    @Test
    public void test12() {
        String[] array = {"a", "b", "c", "d", "e"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));


        int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(x -> System.out.println(x));

        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(intArray);
        //temp.forEach(x->System.out.println(x));

        // Cant print Stream<int[]> directly, convert / flat it to IntStream
        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));
    }


    /**
     * 函数式编程无法做出类似break跳出for循环的操作  return 相当于continue
     *
     * @author Yongjian.Liu
     * @date 2019/1/4 10:23
     */
    @Test
    public void test13(){
        List<String> strList = Arrays.asList(new String[]{"hello", "world","you"});
        strList.forEach(curStr ->{
            if("world".equals(curStr)){
                return;
            }
            System.out.println(curStr);
        });
    }

    /***
     * map的入参为一个 函数式编程接口，可以作为定义为一个函数
     */
    @Test
    public void test14(){
        System.out.println(multConvert.apply(15));
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().map(multConvert).forEach(System.out::println);
    }

    
    /**
     *  定义一个函数式方法，如果function的方法体较复杂的话，提取出来
     *
     * @author Yongjian.Liu
     * @date 2019/4/4 14:20
     */
    Function<Integer,Integer> multConvert = (from) -> from * 3;




}
