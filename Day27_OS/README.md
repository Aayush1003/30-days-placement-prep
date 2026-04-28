# 📅 Day 27: Operating Systems — Revision Notes

## 📝 Key Topics for Interview

---

### 1. Process vs Thread
| Feature | Process | Thread |
|---------|---------|--------|
| Memory | Separate address space | Shared address space |
| Communication | IPC (pipes, sockets) | Shared memory |
| Overhead | High (context switch) | Low |
| Crash Impact | Isolated | Can crash entire process |

### 2. Process States
```
New → Ready → Running → Waiting → Ready → Running → Terminated
```

### 3. CPU Scheduling Algorithms
| Algorithm | Preemptive | Starvation | Notes |
|-----------|-----------|------------|-------|
| FCFS | No | No | Convoy effect |
| SJF | No | Yes | Optimal avg wait |
| SRTF | Yes | Yes | Preemptive SJF |
| Round Robin | Yes | No | Time quantum based |
| Priority | Both | Yes | Use aging to prevent |
| MLQ | Yes | Possible | Multiple queues |

### 4. Process Synchronization
- **Critical Section Problem**: Mutual exclusion, progress, bounded waiting
- **Mutex**: Binary lock (only owner can unlock)
- **Semaphore**: Counting semaphore (wait/signal, P/V operations)
- **Monitor**: High-level abstraction with condition variables

### 5. Deadlock
- **Conditions** (all must hold): Mutual Exclusion, Hold & Wait, No Preemption, Circular Wait
- **Prevention**: Violate any one condition
- **Avoidance**: Banker's Algorithm (safe state check)
- **Detection**: Wait-for graph (cycle = deadlock)
- **Recovery**: Kill process, preempt resource

### 6. Memory Management
- **Paging**: Fixed-size pages, page table, no external fragmentation
- **Segmentation**: Variable-size segments, external fragmentation possible
- **Virtual Memory**: Pages on disk, loaded on demand (demand paging)
- **Page Replacement Algorithms**: FIFO, LRU, Optimal, LFU
  - **Belady's Anomaly**: FIFO can have more faults with more frames

### 7. Page Replacement
| Algorithm | Description | Belady's Anomaly |
|-----------|-------------|-----------------|
| FIFO | Replace oldest page | Yes |
| LRU | Replace least recently used | No |
| Optimal | Replace page used farthest in future | No |

### 8. Thrashing
- When a process spends more time swapping than executing
- **Solution**: Working set model, page fault frequency

### 9. File Systems
- **Allocation**: Contiguous, Linked, Indexed
- **Directory Structure**: Single-level, Two-level, Tree, Acyclic graph

### 10. Important Formulas
```
Effective Access Time = hit_ratio × memory_time + (1 - hit_ratio) × (memory_time + page_fault_time)
Turnaround Time = Completion Time - Arrival Time
Waiting Time = Turnaround Time - Burst Time
```

---

## 🔗 Resources
- [Knowledge Gate OS Playlist](https://www.youtube.com/c/KnowledgeGatePlus)
- [Gate Smashers OS](https://www.youtube.com/c/GateSmashers)
