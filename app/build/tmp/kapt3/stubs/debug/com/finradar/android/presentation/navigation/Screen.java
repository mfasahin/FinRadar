package com.finradar.android.presentation.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AddSubscription", "Alerts", "Dashboard", "EditSubscription", "Onboarding", "Subscriptions", "Lcom/finradar/android/presentation/navigation/Screen$AddSubscription;", "Lcom/finradar/android/presentation/navigation/Screen$Alerts;", "Lcom/finradar/android/presentation/navigation/Screen$Dashboard;", "Lcom/finradar/android/presentation/navigation/Screen$EditSubscription;", "Lcom/finradar/android/presentation/navigation/Screen$Onboarding;", "Lcom/finradar/android/presentation/navigation/Screen$Subscriptions;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$AddSubscription;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class AddSubscription extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.AddSubscription INSTANCE = null;
        
        private AddSubscription() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$Alerts;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Alerts extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.Alerts INSTANCE = null;
        
        private Alerts() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$Dashboard;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Dashboard extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$EditSubscription;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "createRoute", "", "id", "", "app_debug"})
    public static final class EditSubscription extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.EditSubscription INSTANCE = null;
        
        private EditSubscription() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(long id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$Onboarding;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Onboarding extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.Onboarding INSTANCE = null;
        
        private Onboarding() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/finradar/android/presentation/navigation/Screen$Subscriptions;", "Lcom/finradar/android/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Subscriptions extends com.finradar.android.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.finradar.android.presentation.navigation.Screen.Subscriptions INSTANCE = null;
        
        private Subscriptions() {
        }
    }
}