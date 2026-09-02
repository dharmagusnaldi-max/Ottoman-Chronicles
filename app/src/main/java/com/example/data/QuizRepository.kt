package com.example.data

import com.example.R
import com.example.model.BadgeReward
import com.example.model.CivilizationPillar
import com.example.model.LevelProgress
import com.example.model.Question
import com.example.model.QuizOption

object QuizRepository {

  val levels = listOf(
    LevelProgress(
      levelId = 1,
      title = "Level 1: Fajar Anatolia",
      subtitle = "Fondasi, Kepemimpinan Awal & Nilai Moral",
      questionRange = "Tantangan 1 - 5",
      totalQuestions = 5,
      iconName = "Sunrise"
    ),
    LevelProgress(
      levelId = 2,
      title = "Level 2: Penaklukan & Ekspansi",
      subtitle = "Timeline Strategis & Penaklukan Konstantinopel",
      questionRange = "Tantangan 6 - 9",
      totalQuestions = 4,
      iconName = "Castle"
    ),
    LevelProgress(
      levelId = 3,
      title = "Level 3: Tokoh-Tokoh Besar",
      subtitle = "Biografi Osman I, Mehmed II, Suleiman I, & Mimar Sinan",
      questionRange = "Tantangan 10 - 12",
      totalQuestions = 3,
      iconName = "Crown"
    ),
    LevelProgress(
      levelId = 4,
      title = "Level 4: Analisis Peradaban",
      subtitle = "Sistem Pendidikan, Hukum, Pemerintahan & Ekonomi Wakaf",
      questionRange = "Tantangan 13 - 14",
      totalQuestions = 2,
      iconName = "Scale"
    ),
    LevelProgress(
      levelId = 5,
      title = "Final Challenge: Nilai Keteladanan",
      subtitle = "Sintesis Kebijaksanaan untuk Pelajar Abad 21",
      questionRange = "Tantangan 15",
      totalQuestions = 1,
      iconName = "Sparkles"
    )
  )

  val questions = listOf(
    // ----------------------------------------------------
    // LEVEL 1: FAJAR ANATOLIA (5 Soal Pemahaman Sejarah)
    // ----------------------------------------------------
    Question(
      id = 1,
      levelId = 1,
      levelName = "Level 1: Fajar Anatolia",
      levelSubtitle = "Asal-Usul Suku Kayi & Emirat Sogut",
      locationEra = "Söğüt, Anatolia Barat (1299 M)",
      narrative = "Kamu mendarat di perbukitan Söğüt. Angin padang rumput mengibarkan panji bersimbolkan busur dan anak panah suku Kayi. Ertugrul dan putranya, Osman I, memimpin para pengungsi nomaden Turkik yang terdesak invasi Mongol untuk membangun pemukiman berdaulat di perbatasan Kekaisaran Bizantium.",
      questionText = "Faktor utama yang mendasari berdirinya Daulah Utsmaniyah di Söğüt pada tahun 1299 Masehi di bawah kepemimpinan Osman I adalah...",
      options = listOf(
        QuizOption('A', "Dukungan penuh armada laut dari Dinasti Abbasiyah di Baghdad"),
        QuizOption('B', "Pelemahan Kesultanan Seljuk Rum akibat invasi Mongol serta kepemimpinan karismatik Osman I menyatukan para Ghazi"),
        QuizOption('C', "Perjanjian damai penyerahan takhta Konstantinopel secara sukarela oleh Kaisar Bizantium"),
        QuizOption('D', "Penemuan tambang emas raksasa di pesisir Laut Hitam yang membiayai seluruh tentara sewaan")
      ),
      correctOption = 'B',
      explanation = "Tepat sekali! Runtuhnya otoritas Kesultanan Seljuk Rum pasca-invasi Mongol di Pertempuran Kose Dag (1243 M) menciptakan kekosongan kekuasaan di Anatolia. Osman I memanfaatkan posisi strategis di wilayah perbatasan (Uj) Söğüt dan menggalang semangat perjuangan para pejuang Ghazi untuk mendeklarasikan kemandirian emirat pada 1299 M.",
      historicalInsight = "Suku Kayi merupakan salah satu dari 24 cabang suku Oghuz Turkik yang bermigrasi ke arah barat mencari padang rumput dan perlindungan.",
      wisdomFragmentTitle = "Fragmen Fondasi Kemandirian",
      analysisPillar = "Faktor Penyebab Perkembangan Peradaban",
      imageResId = R.drawable.img_anatolia_dawn
    ),

    Question(
      id = 2,
      levelId = 1,
      levelName = "Level 1: Fajar Anatolia",
      levelSubtitle = "Strategi Geopolitik Awal",
      locationEra = "Lembah Sakarya, Anatolia (Awal Abad ke-14)",
      narrative = "Di sekitar Osman I, berdiri berbagai kepangeranan Muslim (Beylik) yang saling bersaing berebut pengaruh. Namun, Osman mengambil keputusan strategis yang visioner dan tidak terburu-buru menyerang saudara seiman.",
      questionText = "Mengapa pada fase awal Osman I lebih memilih memfokuskan ekspansi ke arah benteng-benteng Bizantium daripada menyerang wilayah beylik Muslim tetangganya di Anatolia?",
      options = listOf(
        QuizOption('A', "Karena wilayah beylik Muslim memiliki benteng yang mustahil ditembus oleh kavaleri nomaden"),
        QuizOption('B', "Untuk menjaga persaudaraan Islam, menghindari perang saudara, serta menjalankan etos 'Ghaza' melawan hegemoni Bizantium"),
        QuizOption('C', "Karena para beylik Muslim telah membayar upeti tahunan dalam jumlah yang sangat besar kepada Osman"),
        QuizOption('D', "Osman diperintahkan oleh Paus di Roma untuk membatasi pergerakan hanya di pesisir utara")
      ),
      correctOption = 'B',
      explanation = "Luar biasa! Osman I secara bijak menghindari konflik internal antar-Muslim di Anatolia. Dengan menerapkan etos Ghaza (perjuangan menegakkan keadilan dan menyebarkan Islam ke arah barat), daulah ini menarik simpati para cendekiawan, dervish, dan prajurit dari seluruh penjuru dunia Islam.",
      historicalInsight = "Strategi ini menjadikan emirat Utsmaniyah dipandang sebagai garda terdepan peradaban Islam yang heroik, bukan dinasti penindas sesama Muslim.",
      wisdomFragmentTitle = "Fragmen Visi Persatuan",
      analysisPillar = "Faktor Penyebab Perkembangan Peradaban",
      imageResId = R.drawable.img_anatolia_dawn
    ),

    Question(
      id = 3,
      levelId = 1,
      levelName = "Level 1: Fajar Anatolia",
      levelSubtitle = "Pilar Moral & Persaudaraan Ahi",
      locationEra = "Bilecik & Eskisehir (1300 M)",
      narrative = "Di sebuah pondok tasawuf yang sederhana, Osman I bersimpuh di hadapan Syaikh Edebali, seorang ulama terkemuka sekaligus pemimpin persaudaraan Ahi (Ahilik).",
      questionText = "Peran krusial organisasi persaudaraan spiritual dan asosiasi pengrajin 'Ahi' (Ahilik) dalam fase pembentukan Daulah Utsmaniyah adalah...",
      options = listOf(
        QuizOption('A', "Menjadi lembaga pemungut pajak impor paksa dari kapal-kapal Eropa"),
        QuizOption('B', "Menyediakan persenjataan api raksasa yang diimpor dari Asia Timur"),
        QuizOption('C', "Menjadi fondasi moral, etika ekonomi pasar yang adil, serta perekat integrasi sosial masyarakat perkotaan"),
        QuizOption('D', "Menggantikan seluruh posisi perdana menteri dengan dewan bangsawan asing")
      ),
      correctOption = 'C',
      explanation = "Benar! Persaudaraan Ahi (Ahilik) memadukan tasawuf dengan etika profesi perdagangan dan kerajinan. Mereka menegakkan standar kejujuran, menolong fakir miskin, dan memberi legitimasi moral-keagamaan bagi kepemimpinan dinasti Utsmaniyah awal.",
      historicalInsight = "Nasihat Syaikh Edebali kepada Osman I: 'Wahai anakku! Engkau kini seorang pemimpin, kami adalah rakyat jelata. Kemarahan adalah milik kami, kesabaran adalah milikmu...' menjadi piagam etika kepemimpinan agung.",
      wisdomFragmentTitle = "Fragmen Integritas Moral",
      analysisPillar = "Hubungan Pendidikan, Sains & Pemerintahan",
      imageResId = R.drawable.img_anatolia_dawn
    ),

    Question(
      id = 4,
      levelId = 1,
      levelName = "Level 1: Fajar Anatolia",
      levelSubtitle = "Mimpi Pohon Osman & Nilai Toleransi",
      locationEra = "Bilecik, Kediaman Syaikh Edebali",
      narrative = "Dalam tidurnya, Osman bermimpi melihat seberkas cahaya rembulan keluar dari dada Syaikh Edebali masuk ke dadanya. Seketika dari pusarnya tumbuh pohon raksasa yang rimbun, menaungi pegunungan Kaukasus, Atlas, Taurus, dan empat sungai besar.",
      questionText = "Secara historis dan filosofis, kisah 'Mimpi Pohon Osman' (Osman's Dream) melambangkan...",
      options = listOf(
        QuizOption('A', "Kekuasaan yang hanya berfokus pada eksploitasi hasil hutan dan pertanian semata"),
        QuizOption('B', "Ramalan bahwa dinasti ini akan musnah dalam waktu kurang dari satu generasi"),
        QuizOption('C', "Visi peradaban dunia yang adil dan mengayomi keragaman berbagai bangsa, etnis, dan agama di tiga benua"),
        QuizOption('D', "Kewajiban seluruh warga Utsmaniyah untuk menjadi rimbawan istana")
      ),
      correctOption = 'C',
      explanation = "Tepat sekali! Simbol pohon kosmik yang akarnya mencengkeram bumi dan cabangnya menaungi tiga benua (Asia, Eropa, Afrika) mencerminkan filosofi pemerintahan Utsmaniyah: kekuasaan bukan untuk kesombongan pribadi, melainkan naungan keadilan bagi umat manusia lintas ras dan keyakinan.",
      historicalInsight = "Pohon ini melambangkan bagaimana Utsmaniyah kelak memayungi jutaan warga dengan sistem 'Millet' yang menjamin otonomi hukum bagi komunitas agama non-Muslim.",
      wisdomFragmentTitle = "Fragmen Naungan Keadilan",
      analysisPillar = "Relevansi Nilai untuk Siswa Masa Kini",
      imageResId = R.drawable.img_anatolia_dawn
    ),

    Question(
      id = 5,
      levelId = 1,
      levelName = "Level 1: Fajar Anatolia",
      levelSubtitle = "Transformasi Menuju Negara Terorganisir",
      locationEra = "Bursa, Kaki Gunung Uludag (1326 M)",
      narrative = "Osman I wafat tepat saat putranya, Orhan Gazi, berhasil membebaskan kota strategis Bursa dari Bizantium. Bursa kemudian ditransformasikan menjadi ibu kota pertama dengan koin dinar resmi dan struktur kenegaraan yang modern.",
      questionText = "Langkah institusional terpenting yang dilakukan oleh Orhan Gazi untuk mentransformasikan kelompok pejuang nomaden menjadi negara berkekuatan profesional adalah...",
      options = listOf(
        QuizOption('A', "Membentuk pasukan infanteri teratur pertama (Yaya & Musallam) serta mencetak mata uang koin perak Akce"),
        QuizOption('B', "Membeli tentara bayaran dari kerajaan Viking Skandinavia"),
        QuizOption('C', "Menghapus seluruh madrasah dan menggantinya dengan akademi maritim tertutup"),
        QuizOption('D', "Memindahkan pusat pemerintahan langsung ke kota Kairo di Mesir")
      ),
      correctOption = 'A',
      explanation = "Sangat tepat! Orhan Gazi tidak hanya menaklukkan wilayah, melainkan membangun kelembagaan formal: membentuk korps tentara terlatih tetap (Yaya dan Musallam), membangun kompleks masjid-madrasah di Bursa, dan mencetak koin Akce sebagai simbol kedaulatan fiskal negara.",
      historicalInsight = "Bursa menjadi pusat perdagangan sutra dunia yang menghubungkan Jalur Sutra Asia dengan pasar Eropa.",
      wisdomFragmentTitle = "Fragmen Pelembagaan Negara",
      analysisPillar = "Faktor Penyebab Perkembangan Peradaban",
      imageResId = R.drawable.img_anatolia_dawn
    ),

    // ----------------------------------------------------
    // LEVEL 2: PENAKLUKAN & EKSPANSI (4 Soal Timeline Sejarah)
    // ----------------------------------------------------
    Question(
      id = 6,
      levelId = 2,
      levelName = "Level 2: Penaklukan & Ekspansi",
      levelSubtitle = "Lompatan ke Daratan Eropa",
      locationEra = "Adrianopel / Edirne, Thrace (1361 M)",
      narrative = "Pasukan Utsmaniyah melintasi Selat Dardanella menuju daratan Eropa. Di bawah Sultan Murad I, kota kuno Adrianopel berhasil dibebaskan dan diganti namanya menjadi Edirne, menjadi ibu kota baru Utsmaniyah di benua Eropa.",
      questionText = "Arti penting pemindahan ibu kota Utsmaniyah dari Bursa ke Edirne (1361 M) dalam timeline sejarah ekspansi adalah...",
      options = listOf(
        QuizOption('A', "Menunjukkan mundurnya Utsmaniyah dari pengaruh politik dunia Islam"),
        QuizOption('B', "Menjadikan Utsmaniyah sebagai kekuatan riil di Eropa dan batu loncatan strategis penaklukan wilayah Balkan"),
        QuizOption('C', "Menghindari perselisihan dengan pedagang rempah-rempah di Laut Merah"),
        QuizOption('D', "Perintah dari Kekhalifahan Fatimiyah untuk memperkuat benteng pertahanan di Yunani")
      ),
      correctOption = 'B',
      explanation = "Tepat sekali! Memindahkan ibu kota ke Edirne di daratan Eropa membuktikan tekad Utsmaniyah menjadi kekuatan transkontinental (Eurasia). Dari Edirne, Utsmaniyah mampu mengontrol jalur perdagangan Via Egnatia dan memperluas integrasi di wilayah Balkan.",
      historicalInsight = "Edirne kelak melahirkan tokoh-tokoh besar seperti Sultan Mehmed II dan arsitek legendaris Mimar Sinan yang membangun mahakarya Masjid Selimiye di kota ini.",
      wisdomFragmentTitle = "Fragmen Lompatan Geopolitik",
      analysisPillar = "Ekspansi Wilayah vs Kemajuan Peradaban",
      imageResId = R.drawable.img_hero_banner
    ),

    Question(
      id = 7,
      levelId = 2,
      levelName = "Level 2: Penaklukan & Ekspansi",
      levelSubtitle = "Pertempuran Penentu di Balkan",
      locationEra = "Dataran Kosovo & Nikopolis (1389 - 1396 M)",
      narrative = "Dua pertempuran besar menguji ketahanan Utsmaniyah: Pertempuran Kosovo (1389) di mana Sultan Murad I syahid di medan laga, serta Pertempuran Nikopolis (1396) di mana Sultan Bayezid I 'Sang Kilat' (Yıldırım) menghancurkan koalisi pasukan salib gabungan Eropa Barat.",
      questionText = "Dampak historis jangka panjang dari kemenangan Utsmaniyah dalam Pertempuran Nikopolis (1396 M) adalah...",
      options = listOf(
        QuizOption('A', "Pembubaran permanen seluruh ordo kesatria di kepulauan Inggris"),
        QuizOption('B', "Runtuhnya hegemoni koalisi feodal Eropa di Eropa Tenggara dan kokohnya kontrol Utsmaniyah di Balkan"),
        QuizOption('C', "Penyerahan seluruh tambang perak di Jerman kepada Utsmaniyah"),
        QuizOption('D', "Berakhirnya perang seratus tahun antara Inggris dan Prancis")
      ),
      correctOption = 'B',
      explanation = "Benar! Kemenangan di Nikopolis mengakhiri upaya militer gabungan Eropa Barat skala besar untuk mengusir Utsmaniyah dari Balkan pada abad ke-14, membuka jalan integrasi budaya dan sosial di Eropa Tenggara yang bertahan selama ratusan tahun.",
      historicalInsight = "Sultan Bayezid I dijuluki 'Yıldırım' (Sang Kilat) karena kecepatannya dalam memobilisasi pasukan melintasi dua benua dalam hitungan hari.",
      wisdomFragmentTitle = "Fragmen Ketangguhan Strategis",
      analysisPillar = "Ekspansi Wilayah vs Kemajuan Peradaban",
      imageResId = R.drawable.img_hero_banner
    ),

    Question(
      id = 8,
      levelId = 2,
      levelName = "Level 2: Penaklukan & Ekspansi",
      levelSubtitle = "Penaklukan Monumental Konstantinopel",
      locationEra = "Benteng Theodosius & Tanduk Emas (29 Mei 1453 M)",
      narrative = "Suara takbir membahana di hadapan benteng setinggi 12 meter yang tak pernah runtuh selama seribu tahun. Sultan Mehmed II yang berusia 21 tahun menerapkan inovasi militer radikal: meriam raksasa Basilica karya insinyur Urban serta memindahkan lebih dari 70 kapal perang melintasi bukit daratan Galata pada satu malam!",
      questionText = "Manakah di bawah ini kombinasi taktik dan inovasi teknologi sains yang paling menentukan keberhasilan penaklukan Konstantinopel pada 1453 M?",
      options = listOf(
        QuizOption('A', "Penggunaan balon udara militer dan senapan mesin otomatis"),
        QuizOption('B', "Rekayasa logistik memindahkan armada kapal melintasi daratan Galata ke Golden Horn dan penggunaan artileri meriam mesiu raksasa"),
        QuizOption('C', "Penyusupan pasukan berkuda melintasi terowongan bawah laut Selat Bosporus"),
        QuizOption('D', "Pemberian ramuan tidur ke dalam seluruh sumber air minum warga kota Konstantinopel")
      ),
      correctOption = 'B',
      explanation = "Luar biasa! Penaklukan Konstantinopel memadukan kejeniusan sains matematika balistik (meriam raksasa Basilica yang mampu melontarkan proyektil 600 kg) dengan kalkulasi logistik melumuri kayu dengan lemak sapi untuk meluncurkan kapal di atas bukit Galata, mengejutkan pertahanan Bizantium dari sisi teluk Golden Horn yang lemah.",
      historicalInsight = "Peristiwa ini menggenapi nubuat Hadits Nabi Muhammad SAW: 'Konstantinopel akan ditaklukkan. Sebaik-baik pemimpin adalah pemimpinnya dan sebaik-baik pasukan adalah pasukannya.'",
      wisdomFragmentTitle = "Fragmen Kejeniusan Taktis",
      analysisPillar = "Hubungan Pendidikan, Sains & Pemerintahan",
      imageResId = R.drawable.img_conquest_istanbul
    ),

    Question(
      id = 9,
      levelId = 2,
      levelName = "Level 2: Penaklukan & Ekspansi",
      levelSubtitle = "Penyatuan Dunia Islam & Gelar Khalifah",
      locationEra = "Kairo, Damaskus & Makkah (1516 - 1517 M)",
      narrative = "Sultan Selim I (Yavuz / Sang Tegas) memimpin ekspedisi ke selatan. Dalam pertempuran Marj Dabiq dan Ridaniya, Utsmaniyah mengalahkan Kesultanan Mamluk. Kunci kota suci Makkah dan Madinah diserahkan kepada Sultan, dan simbol-simbol kenabian dipindahkan ke Istana Topkapi.",
      questionText = "Konsekuensi geopolitik dan religius paling fundamental dari ekspedisi Sultan Selim I ke Timur Tengah (1516–1517 M) adalah...",
      options = listOf(
        QuizOption('A', "Sultan Utsmaniyah resmi memangku gelar Khalifah pelindung Dua Tanah Suci (Khadim al-Haramayn) dan menyatukan pusat peradaban Islam"),
        QuizOption('B', "Dihapuskannya seluruh jalur ibadah haji bagi kaum Muslimin non-Turki"),
        QuizOption('C', "Pemindahan Ka'bah dari Makkah ke pelataran Masjid Hagia Sophia di Istanbul"),
        QuizOption('D', "Pembentukan aliansi militer dengan penjajah Portugis untuk mengontrol Samudra Hindia")
      ),
      correctOption = 'A',
      explanation = "Tepat sekali! Kemenangan atas Mamluk menjadikan Utsmaniyah pemegang legitimasi spiritual tertinggi umat Islam sedunia. Sultan Selim I menolak gelar 'Penguasa Dua Tanah Suci' dan dengan rendah hati memilih gelar 'Khadim al-Haramayn al-Syarifayn' (Pelayan Dua Tanah Suci Makkah dan Madinah).",
      historicalInsight = "Benda-benda peninggalan suci (Amanat Suci) seperti pedang para sahabat dan jubah Nabi Muhammad SAW hingga kini tersimpan terawat di Museum Istana Topkapi.",
      wisdomFragmentTitle = "Fragmen Legitimasi Khilafah",
      analysisPillar = "Faktor Penyebab Perkembangan Peradaban",
      imageResId = R.drawable.img_hero_banner
    ),

    // ----------------------------------------------------
    // LEVEL 3: TOKOH-TOKOH BESAR (3 Soal Biografi Tokoh)
    // ----------------------------------------------------
    Question(
      id = 10,
      levelId = 3,
      levelName = "Level 3: Tokoh-Tokoh Besar",
      levelSubtitle = "Sultan Mehmed II (Al-Fatih) Sang Polimatik",
      locationEra = "Istana Topkapi & Gereja Hagia Sophia (1453 - 1481 M)",
      narrative = "Mehmed II tidak hanya panglima perang yang ulung, ia adalah seorang sarjana sejati. Ia menguasai 7 bahasa (Turki, Arab, Persia, Yunani Kuno, Latin, Ibrani, Serbia), mendalami matematika, astronomi bersama Ali Qushji, dan mencintai seni filsafat.",
      questionText = "Tindakan Sultan Mehmed II pasca-penaklukan Konstantinopel yang mencerminkan nilai peradaban tinggi dan toleransi kemanusiaan adalah...",
      options = listOf(
        QuizOption('A', "Mengusir paksa seluruh penduduk non-Muslim dan membakar perpustakaan kota"),
        QuizOption('B', "Menerbitkan piagam perlindungan (Ahdname), mengangkat Patriark Gereja Ortodoks Gennadius Scholarios, dan menjamin kebebasan ibadah"),
        QuizOption('C', "Menutup seluruh akses perdagangan laut bagi bangsa asing"),
        QuizOption('D', "Mengharuskan seluruh penduduk berbicara hanya dalam satu bahasa daerah Anatolia")
      ),
      correctOption = 'B',
      explanation = "Sangat tepat! Sikap humanis Mehmed II menjadi teladan peradaban dunia. Ia mengeluarkan piagam jaminan perlindungan hak asasi bagi pendeta dan warga Kristen serta Yahudi, mendanai rekonstruksi kota, serta mendirikan kompleks universitas Fatih Külliyesi yang memadukan sains dan agama.",
      historicalInsight = "Piagam Ahdname yang diberikan kepada biarawan Fransiskan di Bosnia (1463 M) diakui sejarawan dunia sebagai salah satu deklarasi tertua tentang kebebasan beragama.",
      wisdomFragmentTitle = "Fragmen Kebijaksanaan Al-Fatih",
      analysisPillar = "Relevansi Nilai untuk Siswa Masa Kini",
      imageResId = R.drawable.img_conquest_istanbul
    ),

    Question(
      id = 11,
      levelId = 3,
      levelName = "Level 3: Tokoh-Tokoh Besar",
      levelSubtitle = "Sultan Suleiman I (Al-Qanuni) Sang Pembaharu Hukum",
      locationEra = "Divan-i Humayun, Istanbul (1520 - 1566 M)",
      narrative = "Di Eropa ia dikenal sebagai 'The Magnificent' (Yang Hebat), namun di dunia Islam rakyat menjulukinya 'Al-Qanuni' (Sang Penyusun Hukum). Di bawah kepemimpinannya, Utsmaniyah mencapai puncak kejayaan wilayah, ekonomi maritim, dan ketertiban hukum peradilan.",
      questionText = "Kontribusi terbesar Sultan Suleiman Al-Qanuni dalam meletakkan tata kelola negara modern adalah...",
      options = listOf(
        QuizOption('A', "Menghapus seluruh undang-undang dan menetapkan keputusan absolut satu orang tanpa musyawarah"),
        QuizOption('B', "Menyusun kodifikasi hukum universal (Kanunname) yang mengharmoniskan hukum syariat dengan hukum tata negara untuk mencegah korupsi dan ketidakadilan"),
        QuizOption('C', "Membubarkan dewan menteri Divan dan melarang pencatatan administrasi kearsipan"),
        QuizOption('D', "Memusatkan seluruh perdagangan hanya untuk konsumsi keluarga istana")
      ),
      correctOption = 'B',
      explanation = "Tepat sekali! Suleiman bersama Mufti Agung Ebussuud Efendi mereformasi dan mengkodifikasi sistem hukum kekaisaran. Kanunname menyelaraskan hukum administrasi negara dengan prinsip keadilan syariat, melindungi petani dari pajak berlebih, serta menetapkan transparansi peradilan yang adil.",
      historicalInsight = "Patung relief Sultan Suleiman dipasang di gedung Kongres Amerika Serikat (US House of Representatives) sebagai salah satu dari 23 tokoh pembuat hukum terbesar dalam sejarah manusia.",
      wisdomFragmentTitle = "Fragmen Supremasi Hukum",
      analysisPillar = "Hubungan Pendidikan, Sains & Pemerintahan",
      imageResId = R.drawable.img_hero_banner
    ),

    Question(
      id = 12,
      levelId = 3,
      levelName = "Level 3: Tokoh-Tokoh Besar",
      levelSubtitle = "Mimar Sinan Sang Arsitek Agung",
      locationEra = "Kompleks Masjid Suleymaniye & Selimiye (Abad ke-16)",
      narrative = "Mimar Sinan, kepala arsitek kekaisaran selama setengah abad, menciptakan lebih dari 300 karya arsitektur monumental. Karyanya menggabungkan estetika spiritual, perhitungan teknik gempa, sirkulasi udara jelaga lilin, dan akustik ruang yang sempurna.",
      questionText = "Kejeniusan sains dan teknik arsitektur yang diterapkan Mimar Sinan dalam merancang mahakarya Masjid Suleymaniye di Istanbul terbukti melalui...",
      options = listOf(
        QuizOption('A', "Pemasangan guci tanah liat di dalam kubah untuk resonansi akustik serta ruang perangkap jelaga lilin untuk memproduksi tinta para kaligrafer"),
        QuizOption('B', "Penggunaan bahan plastik tahan api yang diimpor dari belahan bumi barat"),
        QuizOption('C', "Pondasi kayu terapung yang dapat berpindah tempat secara manual saat terjadi badai"),
        QuizOption('D', "Penolakan terhadap penggunaan pilar penyangga demi menghemat biaya bangunan")
      ),
      correctOption = 'A',
      explanation = "Luar biasa! Mimar Sinan merancang 'ruang jelaga' (is odası) di atas pintu masuk: aliran udara menyedot jelaga dari ribuan lilin penerang ke satu ruangan khusus, lalu jelaga tersebut diolah menjadi tinta hitam berkualitas tinggi untuk menulis manuskrip Al-Qur'an. Ia juga memasang 64 guci tanah liat di sudut kubah demi kesempurnaan resonansi suara imam.",
      historicalInsight = "Masjid Suleymaniye dan Selimiye telah bertahan melewati puluhan gempa bumi dahsyat tanpa retak berarti berkat pondasi elastis berlapis mortar hidrolik karya Sinan.",
      wisdomFragmentTitle = "Fragmen Keagungan Sains Arsitektur",
      analysisPillar = "Hubungan Pendidikan, Sains & Pemerintahan",
      imageResId = R.drawable.img_hero_banner
    ),

    // ----------------------------------------------------
    // LEVEL 4: ANALISIS PERADABAN & RELEVANSI (2 Soal Analisis Peradaban)
    // ----------------------------------------------------
    Question(
      id = 13,
      levelId = 4,
      levelName = "Level 4: Analisis Peradaban & Relevansi",
      levelSubtitle = "Analisis Sistem Pendidikan & Meritokrasi",
      locationEra = "Madrasah Sahn-ı Seman & Akademi Istana Enderun",
      narrative = "Kamu memasuki halaman Akademi Enderun di dalam Istana Topkapi. Di sini, pemuda berbakat dari berbagai pelosok negeri dididik dengan kurikulum multidisiplin: al-Qur'an, sains astronomi, matematika, 3 bahasa, seni lukis/musik, dan kepemimpinan taktis.",
      questionText = "Berdasarkan analisis peradaban, bagaimana sistem pendidikan Madrasah dan Akademi Enderun Utsmaniyah mampu mencetak birokrat dan pemimpin berintegritas tinggi?",
      options = listOf(
        QuizOption('A', "Hanya menerima anak keturunan bangsawan kaya tanpa melalui tes bakat apapun"),
        QuizOption('B', "Menerapkan prinsip meritokrasi ketat, pembinaan karakter moral spiritual terpadu dengan sains rasional, dan evaluasi potensi individual tanpa membedakan latar belakang etnis"),
        QuizOption('C', "Fokus 100% hanya pada latihan fisik perang dan melarang membaca literatur asing"),
        QuizOption('D', "Menyerahkan seluruh kurikulum pendidikan kepada perusahaan asing dengan sistem laba komersial")
      ),
      correctOption = 'B',
      explanation = "Tepat sekali! Akademi Enderun dan sistem Madrasah Utsmaniyah merupakan salah satu sistem meritokrasi terbaik di dunia pramodern. Seseorang dapat diangkat menjadi Wazir Agung (Perdana Menteri) atau Panglima bukan karena keturunan darah, melainkan karena kecerdasan moral, kompetensi intelektual, dan integritasnya.",
      historicalInsight = "Integrasi antara ilmu agama (naqli) dan ilmu rasional (aqli) menghasilkan generasi cendekiawan yang sekaligus administrator negara ulung.",
      wisdomFragmentTitle = "Fragmen Meritokrasi Pendidikan",
      analysisPillar = "Hubungan Pendidikan, Sains & Pemerintahan",
      imageResId = R.drawable.img_hero_banner
    ),

    Question(
      id = 14,
      levelId = 4,
      levelName = "Level 4: Analisis Peradaban & Relevansi",
      levelSubtitle = "Analisis Ekonomi Filantropi Sistem Wakaf",
      locationEra = "Kompleks Külliye, Darussifa & Imaret",
      narrative = "Di tengah kota Utsmaniyah, kompleks Külliye menyediakan rumah sakit jiwa berbasis terapi musik (Darussifa), dapur umum gratis untuk siapa saja (Imaret), pemandian umum, dan perpustakaan, semuanya beroperasi gratis selama ratusan tahun tanpa menggunakan uang pajak istana.",
      questionText = "Mengapa sistem Wakaf (Vakıf) Utsmaniyah dipandang sebagai pilar peradaban ekonomi yang paling berkeadilan sosial dan mandiri?",
      options = listOf(
        QuizOption('A', "Karena sistem wakaf membiayai seluruh fasilitas publik, pendidikan, dan kesehatan secara otonom dari aset produktif para dermawan, mencegah penumpukan harta pada segelintir elit"),
        QuizOption('B', "Karena sistem ini mencetak utang luar negeri dalam jumlah besar untuk membiayai pesta pejabat"),
        QuizOption('C', "Karena hanya orang miskin yang diwajibkan menyumbangkan seluruh tanah mereka kepada sultan"),
        QuizOption('D', "Karena wakaf hanya melayani kalangan militer aktif di daerah perbatasan saja")
      ),
      correctOption = 'A',
      explanation = "Benar! Sistem Wakaf Utsmaniyah adalah mahakarya ekonomi Islam: tanah produktif, ruko pasar (bazaar), dan perkebunan diwakafkan, dan hasil keuntungannya digunakan secara abadi untuk membiayai rumah sakit, beasiswa pelajar madrasah, dan jaminan makanan bagi fakir miskin lintas suku dan agama.",
      historicalInsight = "Sejarawan mencatat: 'Seorang warga Utsmaniyah bisa lahir di rumah sakit wakaf, belajar di sekolah wakaf, membaca buku di perpustakaan wakaf, dan dimakamkan di tanah wakaf tanpa sepeser pun biaya.'",
      wisdomFragmentTitle = "Fragmen Filantropi Berkelanjutan",
      analysisPillar = "Faktor Penyebab Perkembangan Peradaban",
      imageResId = R.drawable.img_hero_banner
    ),

    // ----------------------------------------------------
    // FINAL CHALLENGE: UJIAN NILAI KETELADANAN (1 Soal Nilai Keteladanan)
    // ----------------------------------------------------
    Question(
      id = 15,
      levelId = 5,
      levelName = "Final Challenge: Ujian Nilai Keteladanan",
      levelSubtitle = "Sintesis Kebijaksanaan untuk Siswa Abad 21",
      locationEra = "Gerbang Masa Depan: Refleksi Sejarah",
      narrative = "Kamu telah mengumpulkan 14 fragmen kebijaksanaan dari Anatolia hingga Istanbul. Kini, Sang Penjaga Waktu menghadapkanmu pada ujian akhir: bagaimana merangkum seluruh pelajaran sejarah Daulah Utsmaniyah menjadi aksi nyata dalam kehidupanmu sebagai pelajar masa kini.",
      questionText = "Setelah menelaah 4 pilar peradaban Utsmaniyah (Faktor Kemajuan, Esensi Peradaban vs Ekspansi, Relasi Sains-Pemerintahan, dan Filantropi Wakaf), manakah kesimpulan paling komprehensif tentang keteladanan yang harus diadopsi pelajar masa kini?",
      options = listOf(
        QuizOption('A', "Kemajuan sejati suatu bangsa dibangun melalui sinergi penguasaan sains multidisiplin, integritas moral keagamaan, kepemimpinan berkeadilan yang melindungi hak sesama, dan kepedulian sosial aktif"),
        QuizOption('B', "Kemajuan hanya diukur dari kekuatan persenjataan militer dan penaklukan fisik atas negara-negara tetangga tanpa perlu belajar sains"),
        QuizOption('C', "Cukup mengagumi masa lalu tanpa perlu berusaha berprestasi atau berkontribusi dalam dunia sains modern"),
        QuizOption('D', "Menolak segala bentuk kemajuan teknologi modern demi mempertahankan cara hidup nomaden tradisional")
      ),
      correctOption = 'A',
      explanation = "SEMPURNA! Jawabanmu merangkum esensi tertinggi sejarah: Kejayaan peradaban bukan sekadar penaklukan tanah di peta, melainkan penaklukan kebodohan melalui ilmu pengetahuan (seperti Mehmed II), penegakan keadilan hukum (seperti Suleiman I), keindahan karya bagi kemanusiaan (seperti Mimar Sinan), dan kepedulian sosial yang nyata (sistem Wakaf). Inilah bekal emas pelajar abad ke-21!",
      historicalInsight = "Nilai keteladanan Utsmaniyah: Literasi multidisiplin, toleransi aktif dalam keberagaman, kepemimpinan meritokratis berintegritas, dan etos filantropi sosial untuk kemaslahatan umat.",
      wisdomFragmentTitle = "Mahkota Kebijaksanaan Universal",
      analysisPillar = "Relevansi Nilai untuk Siswa Masa Kini",
      imageResId = R.drawable.img_app_icon
    )
  )

  val civilizationPillars = listOf(
    CivilizationPillar(
      id = "pillar_a",
      title = "Pilar A: Faktor Penyebab Perkembangan Peradaban",
      questionPrompt = "Apa saja faktor utama penyebab pesatnya perkembangan peradaban Daulah Utsmaniyah dari sekadar emirat kecil menjadi kekaisaran adidaya dunia?",
      historicalAnalysis = "Perkembangan Daulah Utsmaniyah didorong oleh 4 faktor fundamental: (1) Posisi geopolitik strategis di persimpangan benua Asia-Eropa, (2) Penerapan meritokrasi terbuka di mana pejabat dipilih atas dasar kompetensi dan integritas (lewat Madrasah dan Enderun), (3) Perlindungan hukum yang adil bagi berbagai etnis/agama melalui sistem Millet, dan (4) Dukungan finansial mandiri dari jaringan Wakaf (Vakıf) yang mendanai sarana publik tanpa membebani kas negara.",
      studentRelevance = "Bagi pelajar, faktor ini mengajarkan bahwa kesuksesan jangka panjang tidak diraih secara instan atau mengandalkan privilese/koneksi, melainkan dibangun melalui etos kerja keras (meritokrasi), kedisiplinan mengasah kompetensi diri, serta keterbukaan dalam berkolaborasi lintas latar belakang.",
      keyTakeaway = "Meritokrasi, stabilitas hukum berkeadilan, dan kemandirian institusi adalah fondasi kemajuan peradaban."
    ),
    CivilizationPillar(
      id = "pillar_b",
      title = "Pilar B: Analisis Ekspansi Wilayah vs Kemajuan Peradaban",
      questionPrompt = "Apakah ekspansi wilayah geografis dan penaklukan militer saja sudah cukup untuk disebut sebagai kemajuan peradaban yang hakiki?",
      historicalAnalysis = "Sejarah membuktikan bahwa ekspansi militer semata TANPA diiringi kemajuan peradaban ilmu, tata hukum, dan moralitas akan runtuh dalam sekejap (sebagaimana bangsa Mongol pada fase awal). Daulah Utsmaniyah bertahan lebih dari 600 tahun justru karena setiap wilayah yang dibebaskan segera dibangun peradaban: didirikan madrasah, rumah sakit, jembatan, sistem pengairan air bersih, pasar tertib, dan perlindungan hak asasi warga.",
      studentRelevance = "Pelajar masa kini belajar bahwa 'menang' bukan soal mendominasi atau mengalahkan orang lain secara fisik/sosial media, melainkan bagaimana kontribusi karya nyata dan nilai manfaat yang kita hadirkan bagi lingkungan sekitar.",
      keyTakeaway = "Keluasan wilayah hanyalah wadah; isi sejati dari peradaban adalah ilmu pengetahuan, karya seni, keadilan hukum, dan kemakmuran kemanusiaan."
    ),
    CivilizationPillar(
      id = "pillar_c",
      title = "Pilar C: Hubungan Pendidikan, Sains, Pemerintahan & Masyarakat",
      questionPrompt = "Bagaimana hubungan sinergis antara sistem pendidikan, riset ilmu pengetahuan, tata kelola pemerintahan, dan kesejahteraan masyarakat Utsmaniyah?",
      historicalAnalysis = "Utsmaniyah membangun siklus peradaban terpadu (Külliye): Lembaga Pendidikan (Madrasah & Enderun) menghasilkan sarjana dan negarawan berakhlak mulia -> Birokrat ini mengelola Pemerintahan secara adil dan tertib hukum (Kanunname) -> Stabilitas ini mendorong riset Sains, Arsitektur (Mimar Sinan), dan Kedokteran (Darussifa) -> Hasil ekonomi didonasikan kembali lewat sistem Wakaf untuk menyokong pendidikan generasi berikutnya.",
      studentRelevance = "Siswa memahami pentingnya integrasi ilmu pengetahuan umum (STEM) dengan pendidikan karakter dan moralitas keagamaan agar tidak melahirkan ilmuwan tanpa empati atau pemimpin yang korup.",
      keyTakeaway = "Pendidikan berkualitas melahirkan kepemimpinan yang berintegritas, yang kemudian menciptakan masyarakat yang berkeadilan dan sejahtera."
    ),
    CivilizationPillar(
      id = "pillar_d",
      title = "Pilar D: Capaian Utsmaniyah Paling Relevan untuk Pelajar Masa Kini",
      questionPrompt = "Manakah capaian peradaban Daulah Utsmaniyah yang paling relevan dan kontekstual untuk dipelajari serta diterapkan oleh siswa SMA saat ini?",
      historicalAnalysis = "Ada 3 capaian paling relevan: (1) Sosok Sultan Mehmed II sebagai teladan pembelajar polimatik (menguasai 7 bahasa, sains matematika, filsafat, dan strategi), (2) Sistem filantropi Wakaf yang mencerminkan tanggung jawab sosial dan empati terhadap sesama yang membutuhkan, (3) Toleransi aktif (Ahdname) dalam merawat keragaman masyarakat multikultural dengan damai dan harmonis.",
      studentRelevance = "Siswa SMA dapat menerapkan: menjadi pembelajar sepanjang hayat dengan literasi digital/bahasa asing, aktif berkontribusi sosial/sukarelawan bagi masyarakat, dan menjunjung tinggi toleransi serta sikap anti-perundungan (anti-bullying) di lingkungan sekolah.",
      keyTakeaway = "Penguasaan literasi multidisiplin, jiwa kepedulian filantropis, dan toleransi aktif adalah bekal utama generasi muda abad ke-21."
    )
  )

  val badges = listOf(
    BadgeReward(
      id = "master_ottoman",
      title = "Master of Ottoman History",
      subtitle = "Puncak Kehormatan Sejarah",
      description = "Diberikan kepada penjelajah yang meraih skor sempurna / luar biasa (1300+ poin), menguasai seluruh kronologi dan nilai peradaban.",
      iconSymbol = "👑",
      minScore = 1300
    ),
    BadgeReward(
      id = "grand_vizier",
      title = "Grand Vizier of Wisdom",
      subtitle = "Wazir Agung Penjaga Kebijaksanaan",
      description = "Diberikan kepada pengambil keputusan ulung yang berhasil mengumpulkan mayoritas fragmen kebijaksanaan dengan skor 1100 - 1299 poin.",
      iconSymbol = "📜",
      minScore = 1100
    ),
    BadgeReward(
      id = "sultan_strategy",
      title = "Sultan of Strategy",
      subtitle = "Pakar Taktik & Timeline",
      description = "Diberikan kepada pemain dengan kemampuan analisis sejarah yang tangguh (skor 800 - 1099 poin).",
      iconSymbol = "⚔️",
      minScore = 800
    ),
    BadgeReward(
      id = "guardian_anatolia",
      title = "Guardian of Anatolia",
      subtitle = "Penjaga Nilai Luhur Fajar Sogut",
      description = "Diberikan atas tekad menyelesaikan perjalanan sejarah dan menyerap nilai keteladanan Utsmaniyah.",
      iconSymbol = "🛡️",
      minScore = 0
    )
  )

  fun getBadgeForScore(score: Int): BadgeReward {
    return badges.firstOrNull { score >= it.minScore } ?: badges.last()
  }
}
