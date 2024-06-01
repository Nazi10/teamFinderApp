import { query } from "@/core/queryClient";

interface Skill {
  id: number;
  name: string;
}

export default async function getSkills({
  id,
}: {
  id: string;
}): Promise<Skill[]> {
  return await query<Skill[]>({
    url: `users/${id}`,
    tags: ["user", id],
    isProtected: false,
  });
}
