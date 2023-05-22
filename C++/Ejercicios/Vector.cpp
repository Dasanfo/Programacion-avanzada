#include <iostream>
#include <vector> 
using namespace std;

int main() 
{
  vector<int>vector01(6,201);
  vector<int>vector02(4,400);
  vector<int>::iterator it;
  int myarray[] = {501, 502, 503, 304,404};

    for(it=vector01.begin();it<vector01.end();it++)
    {
      cout<<" "<<*it;
      cout<<endl;
    }
  it=vector01.begin();
  it=vector01.insert(it,200);
  vector01.insert(it,2,300);
    for(it=vector01.begin();it<vector01.end();it++)
    {
      cout<<" "<<*it;
      cout<<endl;    
    }
  //it no valido asignar de nuevo.
  it=vector01.begin();
  vector01.insert(it+2,vector02.begin(),vector02.end());
  cout<<"Mi vector contiene "<<endl;
    for(it=vector01.begin();it<vector01.end();it++)
    {
      cout<<" "<<*it;
      cout<<endl;    
    }

  return 0;
}
