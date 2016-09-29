#coding:utf-8
'''
今日头条2017秋招编程题
输入:n,m
输出从  1 到  n 的数按  字典序  排序的低  m 个数
如输入：11 4
1 10 11 2 3 4 5 6 7 8 9 中的第四个数
输出： 2
'''
import numpy as np
from numpy import *


s = raw_input()
s = s.split(' ')
n = int(s[0])
m = int(s[1])
nn = 0
nlen = len(str(n))
str_list = '0123456789'
reslist = []
print n,m,nlen,str_list[0],str_list[1],str_list[2]

def fun(a):
    global m,n,nn,str_list,reslist
    
    if nn>=m:
        print 'nn=',nn
        return
    elif len(a)>nlen:
            print 'a=',a,' so',len(a),'>',nlen
            return
    elif int(a)>n :
            print a,'>',n,':','a>n'
            return 
    else: 
        reslist.append(a)
        nn+=1
        print nn,'\t',a
        
    if (len(a)<nlen)&(nn<m):   
        for j in range(10): 
            temp = '' 
            temp = str(a)+str_list[j]
            fun(temp)


for i in range(1,10):   
    if nn<m:fun(str(i))

 
print reslist
print reslist[-1] 

  
        