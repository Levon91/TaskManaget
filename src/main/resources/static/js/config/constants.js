'use strict';

TaskManager.app.constant('Config', {

    BASE_URL: 'http://localhost:9000',
    CLIENT_ID: 'task_manager',
    CLIENT_SECRET: '37a8b689-5bd1-4369-a019-b320fbe59f45',
    GRANT_PATH: '/oauth/token',
    REVOKE_TOKEN: '/oauth/revoke',

    USER_KEY: 'user',

    routes: {

        login: {
            name: 'login',
            title: 'Login page',
            url: '/login',
            templateUrl: "/partials/pages/login.html",
            controller: 'login',
            isAuth: false
        },

        home: {
            name: 'home',
            title: 'User home page',
            url: '/home',
            controller: 'home',
            templateUrl: "/partials/pages/home.html",
            isAuth: true
        },

        admin_home: {
            name: 'admin_home',
            title: 'Admin home page',
            url: '/admin/home',
            controller: 'admin',
            templateUrl: "/partials/pages/admin/home.html",
            isAuth: true,
            isAdmin: true
        },

        user: {
            name: 'user',
            title: 'Create User',
            url: '/users',
            controller: 'user',
            templateUrl: "/partials/pages/admin/create_user.html",
            isAuth: true,
            isAdmin: true
        },

        task: {
            name: 'task',
            title: 'Create Task',
            url: '/tasks',
            controller: 'task',
            templateUrl: "/partials/pages/admin/create_task.html",
            isAuth: true,
            isAdmin: true
        },

        project: {
            name: 'project',
            title: 'Create User',
            url: '/projects',
            controller: 'project',
            templateUrl: "/partials/pages/admin/create_project.html",
            isAuth: true,
            isAdmin: true
        }
    }
});