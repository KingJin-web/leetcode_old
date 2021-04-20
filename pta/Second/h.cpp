//#include <iostream>
//#include <bits/stdc++.h>
//using namespace std;
//int main()
//{
//    int N;
//    double p;
//    cin >> N >> p;
//    double p2 = 1 - p, a = 1;
//    int arr[N];
//
//    int N2;
//    double s;
//    cin >> N2 >> s;
//    double s2 = 1 - s, a2 = 1;
//    int arr2[N2];
//
//    for (int i = 0; i < N; i++)
//    {
//        cin >> arr[i];
//    }
//    for (int i = 0; i < N2; i++)
//    {
//        cin >> arr2[i];
//    }
//    for (int i = 0; i < N; i++)
//    {
//        if (arr[i] / 2 == 0)
//            a *= p2;
//        else
//            a *= p;
//    }
//
//    for (int i = 0; i < N2; i++)
//    {
//        if (arr2[i] / 2 == 0)
//            a2 *= s2;
//        else
//            a2 *= s;
//    }
//    printf("%.7f\n", a);
//
//    printf("%.7f", a2);
//}


#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main(){
    int N;
    double p;
    cin >>N>>p;
    double p2=1-p,a = 1;
    int arr[N];



    for(int i =0;i<N;i++){
        cin>>arr[i];
    }
    for(int i =0;i<N;i++){
        if(arr[i]/2==0)
            a*=p2;
        else
            a*=p;
    }


    printf("%.7f\n",a);


}
