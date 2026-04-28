# 📅 Day 29: Computer Networks — Revision Notes

## 📝 Key Topics for Interview

---

### 1. OSI Model (7 Layers)
| Layer | Name | Protocol/Device | Data Unit |
|-------|------|-----------------|-----------|
| 7 | Application | HTTP, FTP, SMTP, DNS | Data |
| 6 | Presentation | SSL/TLS, JPEG, ASCII | Data |
| 5 | Session | NetBIOS, PPTP | Data |
| 4 | Transport | TCP, UDP | Segment |
| 3 | Network | IP, ICMP, ARP | Packet |
| 2 | Data Link | Ethernet, MAC | Frame |
| 1 | Physical | Hub, cables | Bits |

### 2. TCP vs UDP
| Feature | TCP | UDP |
|---------|-----|-----|
| Connection | Connection-oriented | Connectionless |
| Reliability | Reliable (ACK, retransmit) | Unreliable |
| Ordering | Ordered delivery | No ordering |
| Speed | Slower | Faster |
| Use Cases | HTTP, FTP, SSH | DNS, video streaming, gaming |

### 3. TCP 3-Way Handshake
```
Client → SYN → Server
Client ← SYN-ACK ← Server  
Client → ACK → Server
```

### 4. TCP Connection Termination (4-Way)
```
Client → FIN → Server
Client ← ACK ← Server
Client ← FIN ← Server
Client → ACK → Server
```

### 5. IP Addressing
- **IPv4**: 32-bit, 4 octets (e.g., 192.168.1.1)
- **IPv6**: 128-bit, 8 groups of hex
- **Classes**: A (1-126), B (128-191), C (192-223), D (multicast), E (experimental)
- **Private IPs**: 10.x.x.x, 172.16-31.x.x, 192.168.x.x
- **Subnetting**: Dividing network into smaller subnets using subnet mask

### 6. Important Protocols
| Protocol | Port | Purpose |
|----------|------|---------|
| HTTP | 80 | Web browsing |
| HTTPS | 443 | Secure web |
| FTP | 20/21 | File transfer |
| SSH | 22 | Secure shell |
| DNS | 53 | Domain name resolution |
| SMTP | 25 | Email sending |
| DHCP | 67/68 | Dynamic IP assignment |

### 7. DNS Resolution Process
1. Browser cache → OS cache → Router cache
2. Recursive DNS resolver
3. Root DNS server → TLD server → Authoritative server
4. IP returned to client

### 8. HTTP Methods & Status Codes
```
GET    — Retrieve resource
POST   — Create resource
PUT    — Update resource (full)
PATCH  — Update resource (partial)
DELETE — Delete resource

200 OK, 201 Created, 301 Redirect, 400 Bad Request
401 Unauthorized, 403 Forbidden, 404 Not Found, 500 Server Error
```

### 9. Network Devices
- **Hub**: Broadcasts to all (Layer 1)
- **Switch**: Forwards to specific MAC (Layer 2)
- **Router**: Routes between networks using IP (Layer 3)
- **Gateway**: Connects different network architectures

### 10. Important Concepts
- **ARP**: IP → MAC address resolution
- **NAT**: Maps private IPs to public IP
- **Firewall**: Filters traffic based on rules
- **CIDR**: Classless Inter-Domain Routing (e.g., 192.168.1.0/24)
- **Sliding Window**: Flow control mechanism in TCP
- **Congestion Control**: Slow start, congestion avoidance, fast retransmit

---

## 🔗 Resources
- [Knowledge Gate CN](https://www.youtube.com/c/KnowledgeGatePlus)
- [Gate Smashers CN](https://www.youtube.com/c/GateSmashers)
