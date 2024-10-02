### Intro Crash Course Videos
**Ordered from most important to least important**
- [Computer Science](https://youtube.com/playlist?list=PLH2l6uzC4UEW0s7-KewFLBC1D0l6XRfye)
- [Programming](https://youtube.com/playlist?list=PLKUb7MEve0TjHQSKUWChAWyJPCpYMRovO)
- [Architecture](https://youtube.com/playlist?list=PL0oekSefhQVJdk0hSRu6sZ2teWM740NtL)
- [Operating Systems](https://youtube.com/playlist?list=PLacuG5pysFbDTmsCRGWsMW_PzIOpXnckw)
- [Linux](https://youtube.com/playlist?list=PLT98CRl2KxKHKd_tH3ssq0HPrThx2hESW)
- [Networks](https://youtube.com/playlist?list=PLTZYG7bZ1u6o6wz9EF9tQt1JS-pUmmKTj)
- [Algorithms](https://youtube.com/playlist?list=PL0v718LJg-7-O5n09pu1wS9mRG6omIWwa)
- [Git](https://youtube.com/playlist?list=PLu-nSsOS6FRIg52MWrd7C_qSnQp3ZoHwW)

### Java Servlet
- [tomcat architecture](https://pdai.tech/md/framework/tomcat/tomcat-overview.html)

### Container Internals
- [Linux Container Primitives](https://youtu.be/Ueu8TuW-IOg?si=kwlJ_1u6Ys7HFDfX)  
  `cgroups`, `namespaces` and `overlay filesystem`
- [Container Networking](https://youtu.be/z-ITjDQT7DU?si=WmxvAkHYGTZ9HC9A)  
  `bridge` and `iptables` i.e How traffic get routed from the host to containers
- [容器网络原理文章](https://typesafe.cn/posts/how-to-add-port-for-docker/)  
  `bridge`, `veth` and `netns`

### OS Confusions
- [PCB and Kernel Stack](https://youtu.be/b4fsyrWegGo)  
  PCB lives in the kernel space which user process cant even read.  
  Each process has 2 stacks, user stack and kernel stack.
- [C# There Is No Thread](https://blog.stephencleary.com/2013/11/there-is-no-thread.html)  
  How exactly `async` call works without threads.
- [libuv Desgin Overview](https://docs.libuv.org/en/v1.x/design.html)  
  Nodejs async uses `libuv` which in turn implements event loop with `epoll`.
- [Event Driven Concurrnt Server](https://eli.thegreenplace.net/2017/concurrent-servers-part-3-event-driven/)  
  `Nodejs`, `Redis` and `Tomcat` all use `epoll`. 
  
