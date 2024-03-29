### 责任链设计模式

#### 优点：

- 将请求的发送者和接收者解耦。
- 有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
- 你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
- 可处理一个请求的对象集合应被动态指定
- 通过改变链内的成员或调动它们的次序，允许你动态地新增或者删除责任。

#### 用途和缺点：

- 经常被使用在窗口系统中，处理鼠标和键盘之类的事件。
- 并不保证请求一定会被执行；如果没有任何对象处理它的话，它可能会落到链尾端之处（这可以是优点也可以是缺点）。
- 可能不容易观察运行时的特征，有碍于除错。

### 自定义注解

作用于处理器实现上，用于指定处理器顺序

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ProcessOrder {
    int value() default 0;
}
```

为了演示效果，模拟一个场景，陆军中有一些请求文书需要处理，假设它在职级链中从下向上传递，直到找到够权限处理它的军官为止，于是需要了解以下职级（由高到低）：

- General 上将
- Captain 上尉
- Lieutenant 中尉
- Corporal 下士
