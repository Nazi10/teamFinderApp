"use client"

import { postLogin } from "@/commands/auth/postLogin";
import FormInput from "@/components/form/FormInput";
import FormPasswordInput from "@/components/form/FormPasswordInput";
import { notification } from "@/components/ui/Notification";
import { useAction } from "next-safe-action/hooks";
import { useRouter } from "next/router";

export default function Login() {
  const router = useRouter();
  const { execute, result, status } = useAction(postLogin, {
    onSuccess: async () => {
      router.push(`/dashboard`);
    },
    onError: (error) => {
      if (error.fetchError ?? error.serverError)
        notification.error(
          error.fetchError ?? error.serverError ?? "An unknown error occurred."
        );
    },
  });

  function onSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const input = new FormData(e.currentTarget);
    execute(input);
  }

  return (
    <div className="flex justify-center align-middle flex-col items-center p-2 gap-4">
      <h1 className="text-4xl font-bold">Sign up</h1>
      <form onSubmit={onSubmit} className="flex flex-col gap-1">
        <FormInput name="email" placeholder="Email" label="Email" />
        <FormInput name="username" placeholder="Username" label="Username" />
        <FormPasswordInput
          name="password"
          placeholder="Password"
          label="Password"
        />
        <FormPasswordInput
          name="confirmPassword"
          placeholder="Confirm Password"
          label="Confirm Password"
        />
      </form>
    </div>
  );
}
