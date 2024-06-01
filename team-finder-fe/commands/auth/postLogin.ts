"use server";

import { mutate, publicAction } from "@/core/commandClient";
import { z } from "zod";
import { zfd } from "zod-form-data";

const schema = zfd.formData({
  email: zfd.text(z.string().email()),
  password: zfd.text(
    z.string().min(8, "Password must be at least 8 characters")
  ),
});

export const postLogin = publicAction(schema, async (req) => {
  const body = {
    email: req.email,
    password: req.password,
  };
  const res = await mutate<Partial<z.infer<typeof schema>>, { token: string }>({
    url: `/signin`,
    body: body,
    method: "POST",
  });

  return res;
});
