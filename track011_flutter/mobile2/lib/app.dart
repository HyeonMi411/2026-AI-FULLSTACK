import 'package:flutter/material.dart';         
// 공통 상단바 레이아웃 (AppLayout)
// import 'shared/components/app_layout.dart';
import 'features/auth/presentation/login_page.dart';
import 'features/auth/presentation/signup_page.dart';
import 'features/auth/presentation/users_page.dart';
import 'features/post/presentation/post_write_page.dart';
import 'features/post/presentation/post_list_page.dart';  //##

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,   // 구글 최신 Meterial Design 3 테마적용
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.blue,   // 파란색 테마헤더
          foregroundColor: Colors.white,  // 글자 하얀색
        ),
      ),
      initialRoute: '/',  // 시작경로
      routes: {        
        '/'      : (context) =>  const PostListPage() ,   // 메인페이지( 게시글 목록 )
        '/login' : (context) => const LoginPage() ,   // 로그인
        '/signup': (context) => const SignupPage(),   // 회원가입     
        '/users' : (context) => const UsersPage(),    // 마이페이지
        '/post-write' : (context) => const PostWritePage(),    // 마이페이지
      },
    );
  }
}

// import 'package:flutter/material.dart';
// import 'features/auth/presentation/login_page.dart';
// import 'features/auth/presentation/signup_page.dart';
// import 'features/auth/presentation/users_page.dart'; 
// // 💡 Step 4~5 게시판 모듈 작성 후 아래 주석 해제
// // import 'features/board/presentation/post_list_page.dart';
// // import 'features/board/presentation/post_write_page.dart';
// // import 'features/board/presentation/post_update_page.dart';

// class App extends StatelessWidget {
//   const App({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: '나의 소셜 앱',
//       debugShowCheckedModeBanner: false,
//       theme: ThemeData(
//         useMaterial3: true,
//         appBarTheme: const AppBarTheme(
//           backgroundColor: Colors.blue,
//           foregroundColor: Colors.white,
//         ),
//       ),
//       initialRoute: '/',
//       routes: {
//         '/': (context) => const UsersPage(), // 게시판 완성 전 임시 메인화면
//         '/login': (context) => const LoginPage(),
//         '/signup': (context) => const SignupPage(),
//         '/users': (context) => const UsersPage(), 
//       },
//     );
//   }
// }



        // '/': (context) => const AppLayout(
        //       child: Center(
        //         child: Text(
        //           'Hello BLUE상단바 🎉',
        //           style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        //         ),
        //       ),
        //     ),

//////////////////////////////////////////////////////////////////////////

// import 'package:flutter/material.dart';

// class App extends StatelessWidget {
//   const App({super.key});

//   @override
//   Widget build(BuildContext context) {
//     // MaterialApp: 앱 전체 테마와 라우팅 테이블을 관리하는 루트 위젯
//     return MaterialApp(
//       title: 'Thejoa703',  // 앱의 대표타이틀
//       debugShowCheckedModeBanner: false, // 우측상단 debug 띠제거
//       initialRoute: '/',  // 앱구동시 최초로 보여줄 메인 라우트 지정
//       routes: {
//         // 루트 경로 매핑 (Scaffold: 기본 레이아웃 뼈대 제공 위젯)
//         '/': (context) => Scaffold(
//               appBar: AppBar(title: const Text('1단계: 라우팅 테스트')), // 헤더 상단바
//               body: const Center(child: Text('앱이 정상적으로 실행되었습니다! 🎉')), // 화면 본문중앙
//             ),
//       },
//     );
//   }
// }