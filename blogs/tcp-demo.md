# `tcpdump` and `strace` TCP/UDP connections

### Screen layout
`ip, lsof, tcpdump, ss, nc0, nc1`

![tcp_demo_screen](https://github.com/user-attachments/assets/21b89f52-eb67-49b7-bdcd-01ad7ebff6b8)

### Check IP and ports
- `ip -br -family inet address`
- `sudo lsof -n -i @127.0.0.1`

### TCP demo
- `sudo tcpdump -i lo tcp and port 8888 or icmp`
- `ss --tcp --all dst 127.0.0.1:8888 or src 127.0.0.1:8888`
- `nc -vvtl localhost 8888`
- `nc -vvt localhost 8888`

![socket_creation](https://github.com/user-attachments/assets/68a9618b-75ac-4129-87c8-13a5519749a3)

### UDP demo
- `sudo tcpdump -i lo udp and port 8888 or icmp`
- `ss --udp --all dst 127.0.0.1:8888 or src 127.0.0.1:8888`
- `nc -vvul localhost 8888`
- `nc -vvu localhost 8888`

![udp_socket_flowchart](https://github.com/user-attachments/assets/adb58d4d-19b6-42a9-bc39-c5e1f847de89)

###  `strace` TCP and UDP server
- `strace nc -tl localhost 8888`
- `strace nc -ul localhost 8888`
```
execve("/usr/bin/nc", ["nc", "-tl", "localhost", "8888"], 0x7fffadd2ac78 /* 56 vars */) = 0
brk(NULL)                               = 0x61628898c000
mmap(NULL, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7f3769d9b000
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory)
openat(AT_FDCWD, "/etc/ld.so.cache", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=79355, ...}) = 0
mmap(NULL, 79355, PROT_READ, MAP_PRIVATE, 3, 0) = 0x7f3769d87000
close(3)                                = 0
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libbsd.so.0", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\0\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\0\0\0\0\0\0\0\0"..., 832) = 832
fstat(3, {st_mode=S_IFREG|0644, st_size=80888, ...}) = 0
mmap(NULL, 86208, PROT_READ, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f3769d71000
mmap(0x7f3769d75000, 49152, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x4000) = 0x7f3769d75000
mmap(0x7f3769d81000, 12288, PROT_READ, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x10000) = 0x7f3769d81000
mmap(0x7f3769d84000, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x12000) = 0x7f3769d84000
mmap(0x7f3769d86000, 192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7f3769d86000
close(3)                                = 0
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libresolv.so.2", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\0\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\0\0\0\0\0\0\0\0"..., 832) = 832
fstat(3, {st_mode=S_IFREG|0644, st_size=68104, ...}) = 0
mmap(NULL, 75912, PROT_READ, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f3769d5e000
mmap(0x7f3769d61000, 40960, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x3000) = 0x7f3769d61000
mmap(0x7f3769d6b000, 8192, PROT_READ, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0xd000) = 0x7f3769d6b000
mmap(0x7f3769d6d000, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0xf000) = 0x7f3769d6d000
mmap(0x7f3769d6f000, 6280, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7f3769d6f000
close(3)                                = 0
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libc.so.6", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\3\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\220\243\2\0\0\0\0\0"..., 832) = 832
pread64(3, "\6\0\0\0\4\0\0\0@\0\0\0\0\0\0\0@\0\0\0\0\0\0\0@\0\0\0\0\0\0\0"..., 784, 64) = 784
fstat(3, {st_mode=S_IFREG|0755, st_size=2125328, ...}) = 0
pread64(3, "\6\0\0\0\4\0\0\0@\0\0\0\0\0\0\0@\0\0\0\0\0\0\0@\0\0\0\0\0\0\0"..., 784, 64) = 784
mmap(NULL, 2170256, PROT_READ, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f3769a00000
mmap(0x7f3769a28000, 1605632, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x28000) = 0x7f3769a28000
mmap(0x7f3769bb0000, 323584, PROT_READ, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1b0000) = 0x7f3769bb0000
mmap(0x7f3769bff000, 24576, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1fe000) = 0x7f3769bff000
mmap(0x7f3769c05000, 52624, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7f3769c05000
close(3)                                = 0
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libmd.so.0", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\0\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\0\0\0\0\0\0\0\0"..., 832) = 832
fstat(3, {st_mode=S_IFREG|0644, st_size=55536, ...}) = 0
mmap(NULL, 57448, PROT_READ, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f3769d4f000
mmap(0x7f3769d51000, 36864, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x2000) = 0x7f3769d51000
mmap(0x7f3769d5a000, 8192, PROT_READ, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0xb000) = 0x7f3769d5a000
mmap(0x7f3769d5c000, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0xc000) = 0x7f3769d5c000
close(3)                                = 0
mmap(NULL, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7f3769d4d000
arch_prctl(ARCH_SET_FS, 0x7f3769d4e140) = 0
set_tid_address(0x7f3769d4e410)         = 27170
set_robust_list(0x7f3769d4e420, 24)     = 0
rseq(0x7f3769d4ea60, 0x20, 0, 0x53053053) = 0
mprotect(0x7f3769bff000, 16384, PROT_READ) = 0
mprotect(0x7f3769d5c000, 4096, PROT_READ) = 0
mprotect(0x7f3769d6d000, 4096, PROT_READ) = 0
mprotect(0x7f3769d84000, 4096, PROT_READ) = 0
mprotect(0x616287658000, 4096, PROT_READ) = 0
mprotect(0x7f3769dd9000, 8192, PROT_READ) = 0
prlimit64(0, RLIMIT_STACK, NULL, {rlim_cur=8192*1024, rlim_max=RLIM64_INFINITY}) = 0
munmap(0x7f3769d87000, 79355)           = 0
rt_sigaction(SIGPIPE, {sa_handler=SIG_IGN, sa_mask=[PIPE], sa_flags=SA_RESTORER|SA_RESTART, sa_restorer=0x7f3769a45320}, {sa_handler=SIG_DFL, sa_mask=[], sa_flags=0}, 8) = 0
socket(AF_UNIX, SOCK_STREAM|SOCK_CLOEXEC|SOCK_NONBLOCK, 0) = 3
connect(3, {sa_family=AF_UNIX, sun_path="/var/run/nscd/socket"}, 110) = -1 ENOENT (No such file or directory)
close(3)                                = 0
socket(AF_UNIX, SOCK_STREAM|SOCK_CLOEXEC|SOCK_NONBLOCK, 0) = 3
connect(3, {sa_family=AF_UNIX, sun_path="/var/run/nscd/socket"}, 110) = -1 ENOENT (No such file or directory)
close(3)                                = 0
getrandom("\x24\xf0\xa5\xfc\x2a\x21\xb0\x09", 8, GRND_NONBLOCK) = 8
brk(NULL)                               = 0x61628898c000
brk(0x6162889ad000)                     = 0x6162889ad000
newfstatat(AT_FDCWD, "/etc/nsswitch.conf", {st_mode=S_IFREG|0644, st_size=594, ...}, 0) = 0
newfstatat(AT_FDCWD, "/", {st_mode=S_IFDIR|0755, st_size=4096, ...}, 0) = 0
openat(AT_FDCWD, "/etc/nsswitch.conf", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=594, ...}) = 0
read(3, "# /etc/nsswitch.conf\n#\n# Example"..., 4096) = 594
read(3, "", 4096)                       = 0
fstat(3, {st_mode=S_IFREG|0644, st_size=594, ...}) = 0
close(3)                                = 0
newfstatat(AT_FDCWD, "/etc/resolv.conf", {st_mode=S_IFREG|0644, st_size=920, ...}, 0) = 0
openat(AT_FDCWD, "/etc/host.conf", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=92, ...}) = 0
read(3, "# The \"order\" line is only used "..., 4096) = 92
read(3, "", 4096)                       = 0
close(3)                                = 0
futex(0x7f3769c0b66c, FUTEX_WAKE_PRIVATE, 2147483647) = 0
openat(AT_FDCWD, "/etc/resolv.conf", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=920, ...}) = 0
read(3, "# This is /run/systemd/resolve/s"..., 4096) = 920
read(3, "", 4096)                       = 0
fstat(3, {st_mode=S_IFREG|0644, st_size=920, ...}) = 0
close(3)                                = 0
openat(AT_FDCWD, "/etc/hosts", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=224, ...}) = 0
lseek(3, 0, SEEK_SET)                   = 0
read(3, "127.0.0.1 localhost\n127.0.1.1 ke"..., 4096) = 224
read(3, "", 4096)                       = 0
close(3)                                = 0
socket(AF_INET, SOCK_STREAM, IPPROTO_TCP) = 3
setsockopt(3, SOL_SOCKET, SO_REUSEADDR, [1], 4) = 0
setsockopt(3, SOL_SOCKET, SO_REUSEPORT, [1], 4) = 0
bind(3, {sa_family=AF_INET, sin_port=htons(8888), sin_addr=inet_addr("127.0.0.1")}, 16) = 0
listen(3, 1)                            = 0
accept4(3, {sa_family=AF_INET, sin_port=htons(48604), sin_addr=inet_addr("127.0.0.1")}, [128 => 16], SOCK_NONBLOCK) = 4
poll([{fd=0, events=POLLIN}, {fd=4, events=0}, {fd=4, events=POLLIN}, {fd=1, events=0}], 4, -1) = 1 ([{fd=4, revents=POLLIN}])
read(4, "hello from client\n", 16384)   = 18
poll([{fd=0, events=POLLIN}, {fd=4, events=0}, {fd=4, events=POLLIN}, {fd=1, events=POLLOUT}], 4, -1) = 1 ([{fd=1, revents=POLLOUT}])
write(1, "hello from client\n", 18hello from client
)     = 18
poll([{fd=0, events=POLLIN}, {fd=4, events=0}, {fd=4, events=POLLIN}, {fd=1, events=0}], 4, -1) = 1 ([{fd=4, revents=POLLIN}])
read(4, "hi from client again\n", 16384) = 21
poll([{fd=0, events=POLLIN}, {fd=4, events=0}, {fd=4, events=POLLIN}, {fd=1, events=POLLOUT}], 4, -1) = 1 ([{fd=1, revents=POLLOUT}])
write(1, "hi from client again\n", 21hi from client again
)  = 21
poll([{fd=0, events=POLLIN}, {fd=4, events=0}, {fd=4, events=POLLIN}, {fd=1, events=0}], 4, -1) = 1 ([{fd=4, revents=POLLIN}])
read(4, "", 16384)                      = 0
shutdown(4, SHUT_RD)                    = 0
close(4)                                = 0
close(3)                                = 0
close(3)                                = -1 EBADF (Bad file descriptor)
exit_group(0)                           = ?
+++ exited with 0 +++
```
