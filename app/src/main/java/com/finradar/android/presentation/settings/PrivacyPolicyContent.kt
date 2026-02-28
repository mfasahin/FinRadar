package com.finradar.android.presentation.settings

object PrivacyPolicyContent {
    fun getTitle(lang: String) = when (lang) {
        "tr" -> "Gizlilik Politikası"
        "de" -> "Datenschutzerklärung"
        "fr" -> "Politique de Confidentialité"
        "es" -> "Política de Privacidad"
        "ar" -> "سياسة الخصوصية"
        "zh" -> "隐私政策"
        "ja" -> "プライバシーポリシー"
        "ru" -> "Политика конфиденциальности"
        else -> "Privacy Policy"
    }

    fun getLastUpdated(lang: String) = when (lang) {
        "tr" -> "Son Güncelleme: 24 Şubat 2026"
        "de" -> "Zuletzt aktualisiert: 24. Februar 2026"
        "fr" -> "Dernière mise à jour : 24 février 2026"
        "es" -> "Última actualización: 24 de febrero de 2026"
        "ar" -> "آخر تحديث: 24 فبراير 2026"
        "zh" -> "最后更新：2026年2月24日"
        "ja" -> "最終更新日：2026年2月24日"
        "ru" -> "Последнее обновление: 24 февраля 2026 г."
        else -> "Last Updated: February 24, 2026"
    }

    fun getSections(lang: String) = when (lang) {
        "tr" -> listOf(
            "1. Veri Gizliliği" to "FinRadar, gizliliğinize en üst düzeyde önem verir. Uygulamamız tarafından taranan veya manuel olarak eklenen hiçbir veri hiçbir uzak sunucuya gönderilmez.",
            "2. Veri İşleme" to "Tüm analiz ve veri işleme süreçleri doğrudan cihazınızda gerçekleşir. Uygulama, banka harcama mesajlarını tespit etmek için bildirim dinleme iznini kullanır ve bu verileri şifreli yerel veritabanında saklar.",
            "3. SQLCipher Güvenliği" to "Verileriniz, endüstri standardı olan AES-256 bit şifreleme ile SQLCipher kullanılarak korunur. Şifreleme anahtarı Android Keystore sisteminde güvenli bir şekilde saklanır.",
            "4. İzinler" to "Uygulama, temel işlevlerini yerine getirmek için 'Bildirim Erişimi' ve isteğe bağlı olarak 'SMS Okuma' izinlerini talep eder. Bu izinler sadece yerel analiz için kullanılır.",
            "5. Veri Silme" to "Uygulama sunucu tabanlı veri saklamaz. Verilerinizi silmek için uygulamayı cihazınızdan kaldırmanız veya 'Uygulama Ayarları > Depolama > Verileri Temizle' adımını izlemeniz yeterlidir. Bu işlem tüm kayıtlarınızı kalıcı olarak siler.",
            "6. Çocukların Gizliliği" to "FinRadar, 13 yaşın altındaki çocukları hedef almaz ve bilerek çocuklardan kişisel veri toplamaz.",
            "7. İletişim" to "Gizlilik politikamız hakkında sorularınız için bizimle iletişime geçebilirsiniz."
        )
        "de" -> listOf(
            "1. Datenschutz" to "FinRadar legt größten Wert auf Ihre Privatsphäre. Keine durch unsere App gescannten oder manuell hinzugefügten Daten werden an Remote-Server gesendet.",
            "2. Datenverarbeitung" to "Alle Analyse- und Datenverarbeitungsprozesse finden direkt auf Ihrem Gerät statt. Die App nutzt die Benachrichtigungszugriffsberechtigung, um Bankausgabennachrichten zu erkennen, und speichert diese Daten in einer verschlüsselten lokalen Datenbank.",
            "3. SQLCipher Sicherheit" to "Ihre Daten sind durch SQLCipher mit der branchenüblichen AES-256-Bit-Verschlüsselung geschützt. Der Verschlüsselungsschlüssel wird sicher im Android Keystore-System gespeichert.",
            "4. Berechtigungen" to "Die App fordert die Berechtigungen 'Benachrichtigungszugriff' und optional 'SMS lesen' an, um ihre Grundfunktionen zu erfüllen. Diese Berechtigungen werden nur für die lokale Analyse verwendet.",
            "5. Datenlöschung" to "Die App speichert keine serverseitigen Daten. Um Ihre Daten zu löschen, deinstallieren Sie einfach die App von Ihrem Gerät oder folgen Sie dem Schritt 'App-Einstellungen > Speicher > Daten löschen'. Dieser Vorgang löscht alle Ihre Aufzeichnungen dauerhaft.",
            "6. Privatsphäre von Kindern" to "FinRadar richtet sich nicht an Kinder unter 13 Jahren und sammelt nicht wissentlich personenbezogene Daten von Kindern.",
            "7. Kontakt" to "Bei Fragen zu unserer Datenschutzerklärung können Sie uns kontaktieren."
        )
        "fr" -> listOf(
            "1. Confidentialité des données" to "FinRadar accorde la plus haute importance à votre vie privée. Aucune donnée numérisée ou ajoutée manuellement par notre application n'est envoyée à un serveur distant.",
            "2. Traitement des données" to "Toutes les analyses et le traitement des données s'effectuent directement sur votre appareil. L'application utilise l'accès aux notifications pour détecter les messages de dépenses bancaires et stocke ces données dans une base de données locale chiffrée.",
            "3. Sécurité SQLCipher" to "Vos données sont protégées par SQLCipher avec le chiffrement AES-256 bits, standard de l'industrie. La clé de chiffrement est stockée de manière sécurisée dans le système Android Keystore.",
            "4. Autorisations" to "L'application demande les autorisations 'Accès aux notifications' et optionnellement 'Lire les SMS'. Celles-ci sont utilisées uniquement pour l'analyse locale.",
            "5. Suppression des données" to "L'application ne stocke pas de données côté serveur. Pour supprimer vos données, désinstallez simplement l'application ou suivez 'Paramètres de l'application > Stockage > Effacer les données'. Cette action supprime définitivement tous vos enregistrements.",
            "6. Vie privée des enfants" to "FinRadar ne s'adresse pas aux enfants de moins de 13 ans et ne collecte pas sciemment de données personnelles auprès des enfants.",
            "7. Contact" to "Pour toute question concernant notre politique de confidentialité, veuillez nous contacter."
        )
        "es" -> listOf(
            "1. Privacidad de datos" to "FinRadar otorga la máxima importancia a su privacidad. Ningún dato escaneado o añadido manualmente por nuestra aplicación se envía a ningún servidor remoto.",
            "2. Procesamiento de datos" to "Todo el análisis y procesamiento de datos tiene lugar directamente en su dispositivo. La aplicación utiliza el acceso a notificaciones para detectar mensajes de gastos bancarios y almacena estos datos en una base de datos local cifrada.",
            "3. Seguridad SQLCipher" to "Sus datos están protegidos mediante SQLCipher con cifrado AES de 256 bits, estándar de la industria. La clave de cifrado se almacena de forma segura en el sistema Android Keystore.",
            "4. Permisos" to "La aplicación solicita los permisos 'Acceso a notificaciones' y opcionalmente 'Leer SMS'. Estos se utilizan únicamente para el análisis local.",
            "5. Eliminación de datos" to "La aplicación no almacena datos en el servidor. Para eliminar sus datos, simplemente desinstale la aplicación o siga 'Configuración de la app > Almacenamiento > Borrar datos'. Esta acción elimina permanentemente todos sus registros.",
            "6. Privacidad de menores" to "FinRadar no está dirigido a menores de 13 años y no recopila conscientemente datos personales de niños.",
            "7. Contacto" to "Para preguntas sobre nuestra política de privacidad, contáctenos."
        )
        "ar" -> listOf(
            "1. خصوصية البيانات" to "تولي FinRadar أهمية قصوى لخصوصيتك. لا يتم إرسال أي بيانات تم فحصها أو إضافتها يدوياً بواسطة تطبيقنا إلى أي خادم بعيد.",
            "2. معالجة البيانات" to "تتم جميع عمليات التحليل ومعالجة البيانات مباشرة على جهازك. يستخدم التطبيق الوصول إلى الإشعارات للكشف عن رسائل الإنفاق البنكي ويخزن هذه البيانات في قاعدة بيانات محلية مشفرة.",
            "3. أمان SQLCipher" to "تتم حماية بياناتك باستخدام SQLCipher مع تشفير AES-256 بت المعياري في الصناعة. يتم تخزين مفتاح التشفير بأمان في نظام Android Keystore.",
            "4. الأذونات" to "يطلب التطبيق أذوني 'الوصول إلى الإشعارات' واختيارياً 'قراءة الرسائل القصيرة'. تُستخدم هذه الأذونات فقط للتحليل المحلي.",
            "5. حذف البيانات" to "لا يخزّن التطبيق بيانات على الخادم. لحذف بياناتك، ما عليك سوى إلغاء تثبيت التطبيق أو اتباع 'إعدادات التطبيق > التخزين > مسح البيانات'. يحذف هذا الإجراء جميع سجلاتك نهائياً.",
            "6. خصوصية الأطفال" to "لا تستهدف FinRadar الأطفال دون سن 13 عاماً ولا تجمع بيانات شخصية منهم عن علم.",
            "7. تواصل معنا" to "لأي أسئلة حول سياسة الخصوصية، يرجى التواصل معنا."
        )
        "zh" -> listOf(
            "1. 数据隐私" to "FinRadar 高度重视您的隐私。我们的应用程序扫描或手动添加的任何数据均不会发送至任何远程服务器。",
            "2. 数据处理" to "所有分析和数据处理均直接在您的设备上进行。应用程序使用通知访问权限检测银行消费消息，并将这些数据存储在加密的本地数据库中。",
            "3. SQLCipher 安全性" to "您的数据通过 SQLCipher 使用行业标准的 AES-256 位加密进行保护。加密密钥安全地存储在 Android Keystore 系统中。",
            "4. 权限" to "应用程序请求\"通知访问\"权限，以及可选的\"读取短信\"权限，这些权限仅用于本地分析。",
            "5. 数据删除" to "应用程序不存储服务器端数据。要删除您的数据，只需从设备卸载应用程序，或按照\"应用设置 > 存储 > 清除数据\"操作。此操作将永久删除您的所有记录。",
            "6. 儿童隐私" to "FinRadar 不面向 13 岁以下儿童，也不会故意收集儿童的个人数据。",
            "7. 联系我们" to "如对我们的隐私政策有任何疑问，请联系我们。"
        )
        "ja" -> listOf(
            "1. データプライバシー" to "FinRadarはお客様のプライバシーを最重要と考えています。アプリがスキャンまたは手動で追加したデータは、いかなる外部サーバーにも送信されません。",
            "2. データ処理" to "すべての分析とデータ処理はデバイス上で直接行われます。アプリは通知アクセス権限を使用して銀行の支出メッセージを検出し、暗号化されたローカルデータベースに保存します。",
            "3. SQLCipherセキュリティ" to "データは業界標準のAES-256ビット暗号化を使用したSQLCipherで保護されています。暗号化キーはAndroid Keystoreシステムに安全に保存されます。",
            "4. パーミッション" to "アプリは「通知アクセス」権限と、任意で「SMS読み取り」権限を要求します。これらはローカル分析のみに使用されます。",
            "5. データ削除" to "アプリはサーバー側にデータを保存しません。データを削除するには、アプリをアンインストールするか、「アプリ設定 > ストレージ > データを消去」の手順に従ってください。この操作ですべての記録が完全に削除されます。",
            "6. 子どものプライバシー" to "FinRadarは13歳未満の子どもを対象としておらず、子どもの個人データを意図的に収集することはありません。",
            "7. お問い合わせ" to "プライバシーポリシーに関するご質問は、お気軽にお問い合わせください。"
        )
        "ru" -> listOf(
            "1. Конфиденциальность данных" to "FinRadar уделяет первостепенное значение вашей конфиденциальности. Никакие данные, отсканированные или добавленные вручную нашим приложением, не отправляются на удалённые серверы.",
            "2. Обработка данных" to "Все процессы анализа и обработки данных выполняются непосредственно на вашем устройстве. Приложение использует доступ к уведомлениям для обнаружения банковских сообщений о расходах и хранит эти данные в зашифрованной локальной базе данных.",
            "3. Безопасность SQLCipher" to "Ваши данные защищены с помощью SQLCipher с отраслевым стандартом шифрования AES-256. Ключ шифрования надёжно хранится в системе Android Keystore.",
            "4. Разрешения" to "Приложение запрашивает разрешения «Доступ к уведомлениям» и, по желанию, «Чтение SMS». Они используются исключительно для локального анализа.",
            "5. Удаление данных" to "Приложение не хранит данные на стороне сервера. Чтобы удалить данные, просто удалите приложение с устройства или выполните шаги «Настройки приложения > Хранилище > Очистить данные». Это действие безвозвратно удаляет все ваши записи.",
            "6. Конфиденциальность детей" to "FinRadar не предназначен для детей до 13 лет и намеренно не собирает личные данные детей.",
            "7. Контакты" to "По вопросам нашей политики конфиденциальности, пожалуйста, свяжитесь с нами."
        )
        else -> listOf(
            "1. Data Privacy" to "FinRadar attaches the highest importance to your privacy. No data scanned or manually added by our app is sent to any remote server.",
            "2. Data Processing" to "All analysis and data processing takes place directly on your device. The app uses notification access to detect bank spending messages and stores this data in an encrypted local database.",
            "3. SQLCipher Security" to "Your data is protected using SQLCipher with industry-standard AES-256 bit encryption. The encryption key is securely stored in the Android Keystore system.",
            "4. Permissions" to "The app requests 'Notification Access' and optionally 'Read SMS' permissions. These are used solely for local analysis.",
            "5. Data Deletion" to "The app does not store server-side data. To delete your data, simply uninstall the app from your device or follow the step 'App Settings > Storage > Clear Data'. This action permanently deletes all your records.",
            "6. Children's Privacy" to "FinRadar does not target children under the age of 13 and does not knowingly collect personal data from children.",
            "7. Contact" to "For questions about our privacy policy, please contact us."
        )
    }
}
