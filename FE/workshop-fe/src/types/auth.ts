export interface User {
    userId: number;
    username: string;
    password?: string; // Make password optional and exclude from response
    role: {
        roleId: number;
        roleName: string;
    };
}

export interface UserResponse {
    users: User[];
}

export interface LoginRequest {
    username: string;
    password: string;
}

export interface LoginResponse {
    token: string;
}


